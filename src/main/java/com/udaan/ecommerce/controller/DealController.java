package com.udaan.ecommerce.controller;

import com.udaan.ecommerce.model.Deal;
import com.udaan.ecommerce.model.Orders;
import com.udaan.ecommerce.repository.DealRepository;
import com.udaan.ecommerce.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/deal")
public class DealController {
    @Autowired
    private DealRepository dealRepository;
    @Autowired
    private OrderRepository orderRepository;

    @PostMapping(path="/create")
    public String createDeal(@RequestBody Deal deal){
        deal = this.dealRepository.save(deal);
        return "The deal is created.";
    }

    @PostMapping(path="/end")
    public String endDeal(@RequestParam Integer dealId){
        Deal deal = this.dealRepository.findById(dealId).get();
        if(deal==null){
            return "No deal exists for given id.";
        }
        deal.setDealStatus("ENDED");
        this.dealRepository.save(deal);
        return "Deal with id "+dealId+" is ended.";
    }

    /*
    Seller dashboard will have button to add or delete. Dashboard will send actual number of items available to be sole.
    Same for endtime.
     */
    @PostMapping(path="/update")
    public String updateDeal(@RequestBody Deal deal){
        Deal oldDeal = this.dealRepository.findById(deal.getId()).get();
        if(oldDeal == null){
            return "No deal exists for given id.";
        }
        oldDeal.setNoOfTotalItems(deal.getNoOfTotalItems());
        oldDeal.setEndTime(deal.getEndTime());
        this.dealRepository.save(oldDeal);
        return "Deal is updated.";
    }
    /*
    User will place the order. Order contains userId and dealId.
    This endpoint will increase no of items sold by one and create the order.
    It will return the order id.
     */
    @PostMapping(path="/claim")
    public String claimDeal(@RequestBody Orders order){

        Deal deal = this.dealRepository.findById(order.getDealId()).get();
        if(deal.getNoOfItemsSold() == deal.getNoOfTotalItems()){
            return "All items in this deal are sold out.";
        }
        deal.setNoOfItemsSold(deal.getNoOfItemsSold()+1);
        order = this.orderRepository.save(order);
        this.dealRepository.save(deal);
        return "Order with id "+order.getId()+" is placed successfully.";
    }




}
