

#####develop ####

jdk : 1.8
tomcat: 8.x
spring-boot:1.5.6
mysql:5.x
centos 7


war:mvn -Dmaven.test.skip=true package










########   API #################

#登录：

 GET请求： http://localhost:8011/webModule/user/login?userName=wbliu&password=e10adc3949ba59abbe56e057f20f883e

 响应：success 或者 error
   
   
 -----------------------------------------
 

#注册：
  
 POST请求： http://localhost:8011/webModule/user/register
 
 参数：{"userName":"test001","password":"123456"}
 
 响应：success 或者 error 或者 User already exist


备注：暂时改成了GET请求，类似于登录功能；



#登出
GET 请求：http://localhost:8011/webModule/user/loginOut?userName=wbliu

响应：success 或者 error


-------------------------------------------
#获得table的结构描述

GET 请求：http://localhost:8011/webModule/business/dataSourceTableDescribe/{tableName}

响应：
  {
      "user_test": [
          {
              "field": "id",
              "type": "int(11)",
              "isNull": "NO",
              "key": "PRI",
              "default0": null,
              "extra": "auto_increment"
          },
          {
              "field": "name",
              "type": "varchar(60)",
              "isNull": "NO",
              "key": "",
              "default0": null,
              "extra": ""
          },
          {
              "field": "password",
              "type": "varchar(50)",
              "isNull": "NO",
              "key": "",
              "default0": null,
              "extra": ""
          }
      ]
  }



-------------------------------------------


#获得某个数据源下的所有表结构：
 
GET请求 ：http://localhost:8011/webModule/business/dataSourceDescribe/NHCBDP_test_db
 
 
 {
    "NHCBDP_test_db": [
        {
            "product_test": [
                {
                    "field": "pId",
                    "type": "int(11)",
                    "isNull": "NO",
                    "key": "PRI",
                    "default0": null,
                    "extra": "auto_increment"
                },
                {
                    "field": "pname",
                    "type": "varchar(50)",
                    "isNull": "NO",
                    "key": "",
                    "default0": null,
                    "extra": ""
                },
                {
                    "field": "price",
                    "type": "int(11)",
                    "isNull": "YES",
                    "key": "",
                    "default0": null,
                    "extra": ""
                }
            ]
        },
        {
            "user_test": [
                {
                    "field": "id",
                    "type": "int(11)",
                    "isNull": "NO",
                    "key": "PRI",
                    "default0": null,
                    "extra": "auto_increment"
                },
                {
                    "field": "name",
                    "type": "varchar(60)",
                    "isNull": "NO",
                    "key": "",
                    "default0": null,
                    "extra": ""
                },
                {
                    "field": "password",
                    "type": "varchar(50)",
                    "isNull": "NO",
                    "key": "",
                    "default0": null,
                    "extra": ""
                }
            ]
        }
    ]
}


------------------------------------------------------

#获得所有数据源的表结构描述

GET请求 ：http://localhost:8011/webModule/business/allDataSourceDescribe


响应：{
    "NHCBDP_userInfo_db": [
        {
            "users": [
                {
                    "field": "id",
                    "type": "varchar(36)",
                    "isNull": "NO",
                    "key": "PRI",
                    "default0": null,
                    "extra": ""
                },
                {
                    "field": "userName",
                    "type": "varchar(50)",
                    "isNull": "NO",
                    "key": "",
                    "default0": null,
                    "extra": ""
                },
                {
                    "field": "password",
                    "type": "varchar(50)",
                    "isNull": "NO",
                    "key": "",
                    "default0": null,
                    "extra": ""
                },
                {
                    "field": "isUsable",
                    "type": "int(1)",
                    "isNull": "NO",
                    "key": "",
                    "default0": "0",
                    "extra": ""
                }
            ]
        }
    ],
    "NHCBDP_test_db": [
        {
            "product_test": [
                {
                    "field": "pId",
                    "type": "int(11)",
                    "isNull": "NO",
                    "key": "PRI",
                    "default0": null,
                    "extra": "auto_increment"
                },
                {
                    "field": "pname",
                    "type": "varchar(50)",
                    "isNull": "NO",
                    "key": "",
                    "default0": null,
                    "extra": ""
                },
                {
                    "field": "price",
                    "type": "int(11)",
                    "isNull": "YES",
                    "key": "",
                    "default0": null,
                    "extra": ""
                }
            ]
        },
        {
            "user_test": [
                {
                    "field": "id",
                    "type": "int(11)",
                    "isNull": "NO",
                    "key": "PRI",
                    "default0": null,
                    "extra": "auto_increment"
                },
                {
                    "field": "name",
                    "type": "varchar(60)",
                    "isNull": "NO",
                    "key": "",
                    "default0": null,
                    "extra": ""
                },
                {
                    "field": "password",
                    "type": "varchar(50)",
                    "isNull": "NO",
                    "key": "",
                    "default0": null,
                    "extra": ""
                }
            ]
        }
    ]
}

------------------------------------------

#新增一条“申请单”记录；

POST请求：http://localhost:8011/webModule/business/commitRequestNote
参数：{"requestName":"test002","requestUserId":"111111","companyName":"company","illustration":"test","content":"select * from test","userName":"wbliu"}

响应：64ad45370ab745b9b7e58daf7fcd7eb1   或者 add error


------------------------------------
#获得用户的所有“申请单”记录；
GET请求：http://localhost:8011/webModule/business/getRequestNote/{userName}

响应：
[
    {
        "formId": "27bfe9758f65430cb6908a9f43d19f31",
        "requestName": "test002",
        "requestUserId": "111111",
        "companyName": "company",
        "illustration": "test",
        "content": "select * from test",
        "status": 0,
        "userName": "wbliu"
    },
    {
        "formId": "64ad45370ab745b9b7e58daf7fcd7eb1",
        "requestName": "test002",
        "requestUserId": "111111",
        "companyName": "company",
        "illustration": "test",
        "content": "select * from test",
        "status": 0,
        "userName": "wbliu"
    },
    {
        "formId": "f3b2a9031f03410d90bfacd11f434745",
        "requestName": "test",
        "requestUserId": "111111",
        "companyName": "company",
        "illustration": "test",
        "content": "select * from test",
        "status": 0,
        "userName": "wbliu"
    }
]

-------------------------------------------------










