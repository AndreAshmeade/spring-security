JSON Web Token

+ Fast
+ Stateless
+ Used across many services

- Compromised Secret Key
- No visiblity to logged in user
- Token can be stolen 

client = send credentials => server
{validates credentials and Creates and signs token}

client <= sends token = server 
{validates token}

client =  sends token to each request => server 

