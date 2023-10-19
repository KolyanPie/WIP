#!/bin/bash

ssh_endpoint=$1
ssh_port=${2:-22}
ssh_path=${3:-wip}

./gradlew clean html:compileGwt html:dist
cd html/build/dist/
tar -cvf tar.tar *
ssh -p $ssh_port $ssh_endpoint "rm -r $ssh_path/*"
scp -P $ssh_port tar.tar $ssh_endpoint:$ssh_path/.
rm tar.tar
ssh -p $ssh_port $ssh_endpoint "\
cd $ssh_path && \
tar -xvf tar.tar && \
rm tar.tar && \
sed -i '/<a class=\"superdev\"/c\' index.html \
"
