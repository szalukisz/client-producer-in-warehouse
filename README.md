# client-producer-in-warehouse
Project realized for subject "Distributed Processing".
The exercise was to create producers and clients, each of them is new thread. 
They are using warehouse as common resource to transfer products between themselves.
Warehouse has given capacity. Access to warehouse resources is synchronized, Clients and Producers try up to 5 times to get/send specific product to storage, If they fail after that time, they choose another product.
