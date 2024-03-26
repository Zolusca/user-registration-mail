### USER REGISTRATION WITH MAIL CONFIRMATION

 ---

#### Set Up
1. JDK 8
2. Maven 3+
3. Mysql Database
4. Email (Gmail service)
---

- Setting Gmail (must have gmail account)
    * login  gmail account [here](https://myaccount.google.com/)
    * find security/keamanan and turn on 2-step verification 
    * find app password and follow's the step (NOTE : copy the password was appeared)

- Creating email template
    * using [MJML](https://mjml.io/) framework
    * put on `src\resources\template`
    * if you want to emmbed image but run on localhost. Upload image at storage service provider where can access for html link, but u can use [imbb](https://id.imgbb.com/) its free for some time. 

- Set your database and email configuration on `src/resources/application.properties`

---
#### Running
1. mvn install
2. mvn spring-boot:run