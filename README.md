# rest-client-example
A simple JAVA REST Client using Unirest API.

This is a JAVA example on how to consume a REST API using the Unirest library (http://unirest.io/java.html).

Please refer to the [pom.xml](https://github.com/carlosbate/rest-client-example/blob/master/pom.xml) file to check the dependencies.

The files have the following purpose:
  * [App](https://github.com/carlosbate/rest-client-example/blob/master/src/main/java/thesis/rest/App.java) - Shows how to use UbiFactoryService
  * [UbiFactoryService](https://github.com/carlosbate/rest-client-example/blob/master/src/main/java/thesis/rest/UbiFactoryService.java) - it is the interface of the REST client that consumes the UbiFactory API
  * [UbiFactoryServiceImpl](https://github.com/carlosbate/rest-client-example/blob/master/src/main/java/thesis/rest/UbiFactoryServiceImpl.java) - the implementation of the UbiFactoryService interface
  * [UbiSOM](https://github.com/carlosbate/rest-client-example/blob/master/src/main/java/thesis/rest/UbiSOM.java) - just a model class to manipulate resources better
