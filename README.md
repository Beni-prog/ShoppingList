# ShoppingList
An electronic store requires an automatic system to allow to shop online. All products existing in the store are contained in a text file.
A product has an id, a brand, a name, a price and the quantity. Input some products in the file.
When the application starts, the client has a window allowing them to shop. All products will be shown in a list with their id, brand, name and price. If the quantity of a certain product is 0, the product will have the string "Out of stock" appended after the product information.
The client will have the chance to apply filters on the products list: a given string for the product name and the lower and the upper limit for the price.
The product list will be updated to contain only those products that fulfill all given criteris: contain the given string and and have the price
within the interval defined. If any of the filtering fields is empty, this will not be considered. Use JavaStreams for this filtering.
The client can choose to buy the selected product and will have to input the desired quantity. If there are not enough pieces, the application 
will show an error message. Otherwise, the product is added to the shopping basket and the quantity is updated. This update will be saved in the products file.
If the product goes out of stock, the product list will also be updated.
The shopping basket wll be visible in the client's window and will show all the purchased product and the total amount to be paid.
