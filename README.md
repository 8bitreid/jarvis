# Jarvis
## Running Jarvis
J.A.R.V.I.S runs in docker.  
We use [sbt-native-packager](https://sbt-native-packager.readthedocs.io/en/stable/) to build our docker image with sbt commands.
to build our image we use:  
```sbtshell
sbt:stage
sbt:publishLocal
```
to run our app we then we use: 
```bash
 docker run --rm -p 9000:9000 jarvis:TAG
``` 

### notes on sbt-native-packager
[sbt-native-packager-docker](https://github.com/sbt/sbt-native-packager/blob/master/src/main/scala/com/typesafe/sbt/packager/docker/DockerPlugin.scala)