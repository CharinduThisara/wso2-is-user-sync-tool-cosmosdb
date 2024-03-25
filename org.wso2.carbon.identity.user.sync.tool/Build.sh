home_path='../wso2is-7.0.0'

JAVA_HOME=/usr/lib/jvm/java-1.8.0-openjdk-amd64 mvn clean install

rm $home_path/repository/components/dropins/com.user.sync.tool-1.0.0.jar
cp target/com.user.sync.tool-1.0.0.jar $home_path/repository/components/dropins/

# rm $home_path/repository/conf/deployment.toml
# cp ../deployment.toml $home_path/repository/conf/

export JAVA_HOME=/usr/lib/jvm/java-17-openjdk-amd64
sh $home_path/bin/wso2server.sh -DosgiConsole