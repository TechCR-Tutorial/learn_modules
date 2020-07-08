package mongo.config;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.data.mongodb.core.MongoTemplate;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientOptions;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;

public class MongoConfiguration {

    String serverHosts = "10.16.32.130, 10.16.32.131, 10.16.32.132";
//    String serverHosts = "10.16.32.130:27017,10.16.32.131:27017,10.16.32.132:27017";
    String userName = "RATES_APP_USER";
    String password = "rat$dev";
    String dbName = "rates";

    public MongoClient mongoClient() {
        List<ServerAddress> serverAddresses = Arrays.stream(serverHosts.split(",")).
            map(ServerAddress::new).collect(Collectors.toList());
        return new MongoClient(serverAddresses,
                MongoCredential.createCredential(userName, dbName, password.toCharArray()),
                MongoClientOptions.builder().build());

    }

    public MongoTemplate getMongoTemplate() {
        return new MongoTemplate(mongoClient(), dbName);
    }
}
