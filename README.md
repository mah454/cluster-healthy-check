## Cluster Health Check

Simple project for test Kubernetes,Mesos,Swarm,... healthy chech .  

#### build and run :
**TomEE 8**     
please install docker-compose and make utilities on your linux os.    
```apt-get instal make docker-compose```   

now simple enter :   
```make```

***test :***    
check-ping script:    
```shell script
> ./check-ping 172.17.0.2 8080 7 3      
41 bytes from 172.17.0.2: count=127 time=12240 ns
41 bytes from 172.17.0.2: count=129 time=11275 ns
41 bytes from 172.17.0.2: count=128 time=14463 ns
41 bytes from 172.17.0.2: count=128 time=12266 ns
41 bytes from 172.17.0.2: count=126 time=12569 ns
41 bytes from 172.17.0.2: count=128 time=14490 ns
41 bytes from 172.17.0.2: count=130 time=11690 ns 
```

health check:
```shell
> curl http://[ip_address]:[port]/api/v1/health?ready=false
[ERROR], please contact to your administrator 

> curl http://[ip_address]:[port]/api/v1/health?ready=true  # default is true
[INFO] Application is ready
```

process check:    
```shell
> curl http://[ip_address]:[port]/api/v1/process?delay=5000 # response received after 5 second
[172.17.0.2] Process completed after 5000 milliseconds
```