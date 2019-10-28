package app.demo.config;


import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;

@Configuration
public class MongoConfig {

    @Value("${mongo.user}")
    private String dbUser;

    @Value("${mongo.password}")
    private String dbPassword;

    @Value("${mongo.database}")
    private String dbName;

    @Value("${mongo.connectionString}")
    private String dbConnectionString;

    @Bean
    public MongoDbFactory mongoDbFactory()
    {
        MongoClientURI uri = new MongoClientURI("mongodb://ingsw:!QAZxsw2#EDC@ingsw-shard-00-00-2pem4.mongodb.net:27017,ingsw-shard-00-01-2pem4.mongodb.net:27017,ingsw-shard-00-02-2pem4.mongodb.net:27017/admin?ssl=true&replicaSet=IngSW-shard-0&authSource=admin&retryWrites=true&w=majority");
        MongoClient mongoClient = new MongoClient(uri);
        return new SimpleMongoDbFactory(mongoClient, this.dbName);
    }

    @Bean
    public MongoTemplate mongoTemplate()
    {
        MongoTemplate mongoTemplate = new MongoTemplate(mongoDbFactory());
        return mongoTemplate;
    }

    private String getConnectionString() {
        return String.format(this.dbConnectionString, this.dbUser, this.dbPassword);
    }
}
