# quotes-oidc

This application shows to use spring boot to build a self contained web application 
that is secured using OAuth2 / OpenId Connect. It leverages the following frameworks

* Flyway 
* Spring Data JPA
* Spring Security
* SpringBoot [DevTools](https://docs.spring.io/spring-boot/docs/current/reference/html/using-boot-devtools.html)

# Required JDK 

**This demo only works on Java 8** due to incompatibility between some some third party libraries 
and Java 11. 

# Run The UAA and the app 

The application requires an OpenId Connect provider, the demo leverages the UAA from CloudFoundry. 
Use the command `./mvnw cargo:run -Puaa` to launch the UAA and wait until it fully started might take
around 20 seconds. The `uaa.yml` file contains the configuration we have hardcoded a single user 
called `user` with password `password` the UAA runs on `http://localhost:8090` 

After the UAA launches run the spring boot app and visit it at `http://localhost:8080` you will be 
redirected to the UAA and can login after which you will be redirected back to the application. 


# DevTools

## DevTools + IntelliJ

DevTools monitors the classpath only therefore you must rebuild an intelliJ project
before DevTools can pick up the changes. Use `Project > Build` to trigger a build.

## DevTools + Eclipse 

Eclipse will automatically rebuild on every file save, when you save a .java file
it will be published to the classpath causing DevTools to pickup the changes.

## How does DevTools Reloading Work? 

Direct from the SpringBoot docs

>The restart technology provided by Spring Boot works by using two classloaders. 
>Classes that do not change (for example, those from third-party jars) are 
>loaded into a base classloader. Classes that you are actively developing are 
>loaded into a restart classloader. When the application is restarted, 
>the restart classloader is thrown away and a new one is created. 
>This approach means that application restarts are typically much faster 
>than “cold starts”, since the base classloader is already available and populated.

## LiveReload

LiveReload is a browser extension that will automatically refresh a WebPage
when it is edited and saved. The LiveReload browser extension is required
for this to work. Check the [SpringBoot docs](https://docs.spring.io/spring-boot/docs/current/reference/html/using-boot-devtools.html#using-boot-devtools-livereload) for details.

## DevTools and the H2 console

If H2 in memory database is being used and DevTools is on the classpath then
SpringBoot will automatically configure the H2 web Console. You can visit the
console to interact with the database. The console is at http://localhost:8080/h2-console
once you are at the console use database name `jdbc:h2:mem:testdb` which is what is printed
by SpringBoot as the database URL

