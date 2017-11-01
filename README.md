# Geek Night : Building Cloud Native Applications Using Spring Boot and Spring Cloud

## Config Server

`> java -jar config-server/target/config-server-0.0.1-SNAPSHOT.jar` 

`> java -jar -Dserver.port=9595 config-server/target/config-server-0.0.1-SNAPSHOT.jar` 

http://localhost:8888

http://localhost:8888/catalog-service/default.json

http://localhost:8888/catalog-service/prod.json


## Service Registry

`> java -jar service-registry/target/service-registry-0.0.1-SNAPSHOT.jar` 

http://localhost:8761

## CatalogService

`> java -jar catalog-service/target/catalog-service-0.0.1-SNAPSHOT.jar` 

http://localhost:9191/products

## InventoryService

`> java -jar inventory-service/target/inventory-service-0.0.1-SNAPSHOT.jar` 

http://localhost:9393/inventory

## OrderService

`> java -jar order-service/target/order-service-0.0.1-SNAPSHOT.jar` 

POST - http://localhost:9292/orders

Payload: 

`{
	"customerEmail":"siva@gmail.com",
	"customerAddress": "Hyderabad",
	"items": [
		{
            "productId" : 1,
            "quantity" : 3,
            "productPrice": 25
		},
		{
            "productId" : 2,
            "quantity" : 1,
            "productPrice": 15
        }
	]
}`

GET - http://localhost:9292/orders/{orderId}


## ShoppingCart-UI

`> java -jar shoppingcart-ui/target/shoppingcart-ui-0.0.1-SNAPSHOT.jar` 

http://localhost:8080

## Hystrix Dashboard

`> java -jar hystrix-dashboard/target/hystrix-dashboard-0.0.1-SNAPSHOT.jar` 

http://localhost:9999/hystrix/

stream=http://localhost:9999/turbine.stream
