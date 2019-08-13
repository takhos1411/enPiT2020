JavaEE用プロジェクトのひな形

This is a template project for JavaEE projects

# System Environment

* Java: openjdk version 12.0.1
* JavaEE: javaee-api 8.0.1
* AS: WildFly 17.0.0
* View: JSF 2.2, foundation 6
* IDE: Intellij IDEA or Maven

# Setup

## WildFly
We will use WildFly as the application server but any JavaEE 8 compliant server will do.
### Download and extract WildFly
1. Download latest release from [WildFly site](http://wildfly.org/downloads/)
2. Install by unpacking to location of your choice
3. Run add-user.bat/sh in (WILDFLY_HOME)/bin to create admin user

## That's it
Finally, in IntelliJ IDEA project, create a Run Configuration to build, deploy, run the app on WildFly.