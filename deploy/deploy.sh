#!/bin/bash

cd ..
ssh_endpoint=$1
ssh_port=${2:-22}
version=${3:-$(./gradlew properties | grep version | sed 's/version: //')}
prev_version=${4:-$version}

./gradlew clean html:compileGwt html:dist
sed -i '/<a class=\"superdev\"/c\' ./html/build/dist/index.html
cd deploy
docker build -t kolyanpie/wip:$version -f Dockerfile ../.
ssh -p $ssh_port $ssh_endpoint "\
docker rm -f wip && \
docker rmi kolyanpie/wip:$prev_version && \
docker run --name wip -p 8280:80 -d kolyanpie/wip:$version
"
docker rmi kolyanpie/wip:$version
