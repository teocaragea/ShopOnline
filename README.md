# ShopOnline

Functionality of ShopOnline.
This project serves as a backend service for an online shop of bracelets and necklage from Natural Stones. We can register as a user. manage orders on website(delete one order), add a product, see all stones, add new stone, update one stone. See all order history and delete one order from history. From what we see, right now the admin functionality is build. In the future we want to extend the logic to fully serve as an online shop, so we want an user to login and order one product from our site.



This is my Database Diagram

![Database Diagram](https://github.com/teocaragea/ShopOnline/blob/master/database.png)

Entities:
Natural Stone - this table contains informations about the natural stone used in products.
Product - this table containts information about product (bracelet or necklage). It contains one to one relationship to Natural Stone table.
Oder - table where i gestionate my orders. I have information regard total price. It has Many to Many relationship with Product table.
User - table that gestionate user that register/log in my aplication.
Delivery - table that gestionate deliveries. It has a boolean value if the order is already payed or not. It has a Many to Many relationship with Order and one to one with user table.
History - table that show history of deliveries to user. It contains information regard the status of order(delivered, delivery in progress) and the date of the order. It has one to one relathionship with Delivery table.

Servicies:
DeliveryService - retrieve all deliveries.
OrderService - retrieve all orders, add a new order, delete one order by its id
UserService - create new user(register), retrieve all users
ProductService - add a product and retrieve all products
NaturalStoneService- retrieve all stones, add new stone and update one stone by its id.
HistoryService - retrieve all histories, delete one history by id, save new history. 
