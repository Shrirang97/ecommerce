##Entities:
- Seller
- Buyer/User
- Deal
- Item

##Assumptions:
- Seller 1...* Deal
- Deal 1...1 Item
- User 1...* Deal


##Database Schema:
User
- id

Deal
- id
- itemId
- noOfTotalItems
- noOfItemsSold
- endTime

Item
- id

Orders
- id
- userId
- dealId