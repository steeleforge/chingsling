# ChingSling

Functional synatic sugar for Java 8 as it relates to the sling API.

## How to build

To build all the modules run in the project root directory the following command with Maven 3:

    mvn clean install

If you have a running AEM instance you can build and package the whole project and deploy into AEM with  

    mvn clean install -P author
    
Or to deploy it to a publish instance, run

    mvn clean install -P publish
    
