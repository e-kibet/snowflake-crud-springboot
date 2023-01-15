# Snowflake spring boot crud

## A simplified example on how to use the snowflake database on a spring boot appication.

This project is an example of the CRUD(Create, Read, Update and Delete) in spring boot using a snowflake database. To understand
more about the snowflake follow this guide: https://docs.snowflake.com/en/

## More about snowflake and spring boot

To be able to understand the snowflake, follow this link:- https://docs.snowflake.com/en/ and spring boot better understanding, 
follow this guide: https://spring.io/projects/spring-boot

## Project setup

1. Clone this repository into your machine
```bash
git clone https://github.com/e-kibet/snowflake-spring-boot-crud.git
```
2. Navigate into the root of this project
```bash 
cd snowflake-spring-boot-crud
```
3. Set up your snowflake account, first register on the snowflake website and login then create your snowflake database.
then configure the following items under application.properties
```bash
spring.datasource.url=
spring.datasource.username=
spring.datasource.password= 
```
4. Note: Make sure the snowflake is granted the proper permission to perform the crud operations. To be able to grant the access
to the user, use below commands:
```bash
create user root password=<<YOUR PASSWORD>> default_role = ACCOUNTADMIN must_change_password = false;

GRANT ROLE ACCOUNTADMIN TO USER <<YOUR USERNAME>>; 
```
5. Run the project on intellj ide or any other ide.


## Example of the data in snowflake database

![Alt text](screenshots/snowflake-crud.png?raw=true "Snowflake example of data")

```### HAPPY CODING ###```