# pac4j-spring-keycloak
Simple project to use pac4j with Spring Security and Keycloak SAML as SSO

## Build app
To build app:
```sh
$ mvn clean package
```
## Deploy war file
To start web server with builded web archive you can use [Payara Micro](http://www.payara.fish/downloads), for example [v.4.1.1.164](https://s3-eu-west-1.amazonaws.com/payara.fish/Payara+Downloads/Payara+4.1.1.164/payara-micro-4.1.1.164.jar)
```sh
$ java -jar payara-micro-4.1.1.164.jar --deploy pac4j-spring-keycloak.war
```
## Run Keycloak server
To start Keycloak server, you can use [Wildfly Swarm Keycloak server](https://wildfly-swarm.gitbooks.io/wildfly-swarm-users-guide/content/server/keycloak.html), for example [v.2017.1](http://repo2.maven.org/maven2/org/wildfly/swarm/servers/keycloak/2017.1/keycloak-2017.1-swarm.jar):
```sh
$ java -Dswarm.port.offset=100 -jar keycloak-2017.1-swarm.jar
```

## Import Keycloak realm
You must import new realm 'saml-demo': upload 'src/main/resources/saml-demo.json' to form: http://localhost:8180/auth/admin/master/console/#/create/realm

Also, for client with name 'http://localhost:8080/pac4j-spring-keycloak/callback?client_name=SAML2Client' of realm with name 'saml-demo' you must import keys from 'src/main/resources/samlKeystore.jks':
```
http://localhost:8180/auth/admin/master/console/#/realms/saml-demo/clients -> Choose Client ID 'http://localhost:8080/pac4j-spring-keycloak/callback?client_name=SAML2Client' -> SAML Keys.
```

### Signing Key import
```
Archive Format: JKS
Key Alias: pac4j-demo
Store Password: pac4j-demo-passwd
Import File: 'src/main/resources/samlKeystore.jks'
```

### Encryption Key import
```
Archive Format: JKS
Key Alias: pac4j-demo
Store Password: pac4j-demo-passwd
Import File: 'src/main/resources/samlKeystore.jks'
```

# Test
If you open http://localhost:8080/pac4j-spring-keycloak/secured, you must be redirect to Keycloak auth form. After you fill it with 'admin'/'password', you must be redirected to http://localhost:8080/pac4j-spring-keycloak/secured.
