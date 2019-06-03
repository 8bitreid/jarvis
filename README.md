# Jarvis
[![CircleCI](https://circleci.com/gh/8bitreid/jarvis.svg?style=svg&circle-token=4c3891041f80f4b3284b5c43c7e0f058700822d4)](https://circleci.com/gh/8bitreid/jarvis) 
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
