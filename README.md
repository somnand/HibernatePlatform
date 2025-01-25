# Hibernate Platform
Storage for all Hibernate Programs. Base taken from spring-boot-crud-example.

Database : H2 Database(Server Based)

### Errors : 
For H2 not functioning properly and asking for Driver:

Delete the H2 jar and reinstall using mvn clean install -DskipTests  
https://stackoverflow.com/questions/40137347/h2-embeded-db-with-spring-boot-error-auto-configuring 

Annotate the Controller classes with @RestController and not @Controller  
https://stackoverflow.com/a/49854383

For connecting DBeaver to H2 Database.
https://stackoverflow.com/questions/75940222/cannot-see-h2-database-tables-and-data-via-dbeaver-or-intellij-idea

Navigate to the location where h2 jar is present as mentioned in the pom.xml. Example : ``cd ~/.m2/repository/com/h2database/h2/2.2.224``<br/>
Command to Run the DB : ``java -cp h2-2.2.224.jar org.h2.tools.Server -tcp -tcpAllowOthers -tcpPort 9092 -ifNotExists``
<br/>
Remember version of H2 DB in application must match the version used by DBeaver.

### Configs : 

Running on Server Port : 6000

Select the type of H2 DB as per need. <br/>
 The Memory one works properly but can be accessed only via the application(also via Postman). But due to inconsistency in the instance DBeaver or any other DB Reading application can't gain access to it.<br/>
 In order to connect to the DB using DBeaver, persist the Database and connect it via using the following connection string. NOTE the DB is added to .gitignore and not tracked.<br/>
 ``jdbc:h2:<location-till-context>\HibernatePlatform\testdb``

#DB_CLOSE_ON_EXIT=false This parameter is used to persist data even after the Server is stopped.

>Following Tutorial : https://www.youtube.com/watch?v=IucFDX3RO9U

>Spring Security : https://www.youtube.com/watch?v=tWcqSIQr6Ks

src/main/java : Contains all Java classes.<br/>  
src/main/resources : Contains the Postman Collections needed to test the application.<br/>
src/main/resources/sql : Contains all SQL scripts used to query H2 persistant database.

```
For mappings please refer the controllers or search "@RestController("
```
 

