package project.dao.impl;

import com.mongodb.*;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import project.model.ProjectsModel;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;

import java.util.ArrayList;
import java.util.List;

import static java.lang.System.out;
import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;

public class MongoBaseController {
    public List<ProjectsModel> getProjectsList(){
        CodecRegistry pojoCodecRegistry = fromRegistries(MongoClient.getDefaultCodecRegistry(),
                fromProviders(PojoCodecProvider.builder().automatic(true).build()));

        MongoClient mongoClient = new MongoClient();
        MongoDatabase database = mongoClient.getDatabase("Projects").withCodecRegistry(pojoCodecRegistry);
        MongoCollection<ProjectsModel> collection = database.getCollection("Projects", ProjectsModel.class);

        List<ProjectsModel> list  = collection.find(ProjectsModel.class).into(new ArrayList<>());
        list.forEach(out::println);
        return list;

    }
}
