# beveragesApp 
#authohr - Vivek Burungale

A beverage factory which serves a variety of drinks, juices etc to the customers from its pre-defined set of menu Items. Calculate the order value based on the actual price of the menu minus the price of the removed ingredient.

API to access with Exclusion Items http://localhost:8080/order?orderDetails=Chai,-sugar,-milk

API to access without Exclusion Items http://localhost:8080/order?orderDetails=Chai

API to place order for multiple Menu items http://localhost:8080/order?orderDetails="Chai,-sugar","Chai","Coffee,-milk"

To access the H2 Console http://localhost:8080/h2
