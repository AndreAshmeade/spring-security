/---------------------------/
/Cross Site Request Forgery /
/---------------------------/

 CSRF occurs when a malicious site or program causes a user's browser to perform an unwanted action on a trusted site when the user is authenticated. Any malicious action is limited to the capability of the website to which the user is authenticated.

 For Example: 

Jane might login to her online banking portal while checking her email. While there, she may click a link in a phishing email (likely obfuscated by a link-shortening site) which would include a request for Jane's bank to transfer money to an account the attacker controls.

Since Jane is already authenticated by her bank, they automatically carry out the transaction, believing that because it is being requested by Jane's browser that she has authorized it.


Visual Aid:
https://i0.wp.com/www.dunebook.com/wp-content/uploads/2016/12/csrf-cross-site-request-forgery.png?resize=800%2C472&ssl=1



1. Client login in Fronetend to server
2. Server sents CSRF Token to Frontend
3. Frontend Client Submit requests with token post, put , delete to Server
4. Server validates token for requests post,put and delete 

When to use CSRF protection

when you use CSRF protection? Our recommendation is to use CSRF protection for any 
request that could be processed by a browser by normal users.If you only creating 
a service that is used by non-browser clients, you will likelu want to disable 
CSRF protection. 
