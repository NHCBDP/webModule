

#####develop ####

jdk : 1.8
tomcat: 8.x
spring-boot:1.5.6
mysql:5.x
centos 7


war:mvn -Dmaven.test.skipt=true package










########   API #################

#登录：

 GET请求： http://localhost:8011/webModule/user/login?userName=wbliu&password=e10adc3949ba59abbe56e057f20f883e

 响应：success 或者 error
   
   
 -----------------------------------------
 

#注册：

 POST请求： http://localhost:8011/webModule/user/register
 
 参数：{"userName":"test001","password":"123456"}
 
 响应：success 或者 error 或者 User already exist


#登出
GET 请求：http://localhost:8011/webModule/user/loginOut?userName=wbliu

响应：success 或者 error

