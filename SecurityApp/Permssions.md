Client: nothing 

ADMIN : read and write 

Admintrainee : read 

annasmith(Client) => nothing
linda(ADMIN) => read and write 
tom(Admintrainee) => read 


Form Based Authentication 
- Username & Password 
- Standard in most websites 
- Can logout
- HTTPS recommended 




client                    server

      POST username password 
      Validates credential
             OK
    Any Request with SESSONID  
                              /DataBase/
    Validates SESSIONID <=  - in memory database  (Expires after 30 mintues of inactivity)   
                            - Postgres
                            - Redis 
     Remember-me cookie (default two weeks)<= 
           200 OK 


Database Authentication
(Linda, annasmith, tom) => DataBase 

