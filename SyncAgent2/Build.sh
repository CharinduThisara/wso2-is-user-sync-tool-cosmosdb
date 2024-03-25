home_path='../wso2is-7.0.0'

JAVA_HOME=/usr/lib/jvm/java-1.8.0-openjdk-amd64 mvn clean install

rm $home_path/repository/components/dropins/com.sync.tool-1.0-SNAPSHOT.jar
cp target/com.sync.tool-1.0-SNAPSHOT.jar $home_path/repository/components/dropins/

rm $home_path/.env
cp ../.env $home_path/
cp src/main/resources/reference.conf ../wso2is-7.0.0/repository/conf/
export JAVA_HOME=/usr/lib/jvm/java-17-openjdk-amd64
sh $home_path/bin/wso2server.sh