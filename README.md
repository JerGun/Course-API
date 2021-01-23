# Software Architecture
📝 Repository of Software Architecture subject work

## Tools & Configuration:

### 🔧 Tools:
  - [Java Standard Edition](https://www.oracle.com/java/technologies/javase-downloads.html)
  - [Spring Tools for Eclipse](https://spring.io/tools)
  - [XAMPP](https://www.apachefriends.org/download.html)
  - [Postman](https://www.postman.com/downloads/)
  - [Visual Studio Code](https://code.visualstudio.com/download)
  
### 📌 Configuration:
Database connect configs in folder src\main\resources\application.properties
```md
spring.datasource.url=jdbc:mysql://localhost/<database>?characterEncoding=utf-8&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC
spring.datasource.username=root
spring.datasource.password=

spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true
spring.jpa.hibernate.ddl-auto=update
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL5Dialect
```