# Book Collection

This simple [Spring Boot](https://spring.io/guides/gs/spring-boot) application was built using [Maven](https://spring.io/guides/gs/maven/).

## Running the application

You can start the application in a couple of ways. In both of these cases, you'll first need to clone the repository. This can be done on the command line, like so:

```
git clone https://github.com/tonifreden/book-collection.git
```

> ### Run the main method from BookCollectionApplication
>
> Fire up Eclipse and import project
> ```
> File -> Import -> Maven -> Existing Maven project
> ```
> Run the application main method
> ```
> Run as -> Java Application
> ```

> ### Use the Maven Spring Boot plugin
>
> Navigate to the project's root directory
> ```
> cd path_to_project/book-collection
> ```
> Run the application using Maven Wrapper
> ```
> ./mvnw spring-boot:run
> ```

You can then access the API at http://localhost:9000/