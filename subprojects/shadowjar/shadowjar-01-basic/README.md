An example using gradle to build and run a shadowjar jvm application.

```
groovy src/main/groovy/HelloWorld.groovy
```

```
gradle run
```

```
gradle shadowJar
java -jar build/libs/shadowjar-01-basic-1.0-SNAPSHOT-all.jar
```
