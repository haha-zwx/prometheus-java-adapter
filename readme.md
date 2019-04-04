# prometheus-java-adapter

> user java application(springboot) as prometheus remote_write server


- prometheus.yml
```$xslt
remote_write: 
  - url: "http://127.0.0.1:9201/write"
``` 

run this application,than you can gei what prometheus get message !
