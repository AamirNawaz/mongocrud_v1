**Instruction for starting the Crud Application with Spring boot and kotlin with MongoDb**



**Step1:**
    clone the repository
    
    git clone https://github.com/AamirNawaz/mongocrud_v1.git


step2:
 Open the repo in IntelliJ IDEA (community or enterprise) choice is yours.
    
    File > Open > choose project

step3:
    Make sure you have install the mongodb or conected with mongo client etc
to see the database.


step4:
create database in mongo either by **mongosh** or through mongo compas

    terminal > mongosh
             
    mongosh > show dbs   //for checking dbs
    mongosh > use database  //for switching to dbs


step5:
update the database name if you have changed the databasename in your

    src > main > resources > application.properties
    

inside > application.properties file you will see

    spring.data.mongodb.uri=mongodb://localhost:27017/crud_db
Here you can update your database name etc and also add if you have any other environment variables.