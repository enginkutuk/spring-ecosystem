- Test End Point
http://localhost:52805/hello-service/test
- Test End Point via API GateWay
http://localhost:8090/hello-service/test
- Multiple Intance Test via API GateWay
Birden fazla intance ayağa kaldır ve sırayla yönlendirdiğini gör.
hello-service yaml'deki önemli parametre : 
instance-id: ${spring.application.name}:${spring.application.instance_id:${random.value}}