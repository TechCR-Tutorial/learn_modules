package mongo.config;

import org.springframework.data.mongodb.core.MongoTemplate;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class MongoConfigurationTest {

    @Test
    public void testGetMongoTemplate() {
        MongoConfiguration mongoConfiguration = new MongoConfiguration();
        MongoTemplate template = mongoConfiguration.getMongoTemplate();
        boolean ren460ModelExist = template.collectionExists("ren460Model");
        Assert.assertTrue(ren460ModelExist);
    }
}