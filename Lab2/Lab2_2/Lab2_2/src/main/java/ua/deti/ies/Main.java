package ua.deti.ies;
import com.mongodb.MongoException;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.result.InsertOneResult;
import org.bson.Document;
import org.bson.Document;
import org.bson.conversions.Bson;
import com.mongodb.client.model.Projections;
import com.mongodb.client.model.Sorts;
import org.bson.types.ObjectId;

import java.util.Arrays;
import java.util.Date;

import static com.mongodb.client.model.Filters.eq;

public class Main {
    public static void main(String[] args) {

        try (MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017")) {
            // Attempt to create a MongoClient instance
            MongoDatabase database = mongoClient.getDatabase("cbd");
            MongoCollection<Document> collection = database.getCollection("restaurantes");

            Bson projectionFields = Projections.fields(
                    Projections.include("nome", "localidade"),
                    Projections.excludeId());

            Document doc = collection.find(eq("localidade", "Bronx"))
                    .projection(projectionFields)
                    .sort(Sorts.descending("nome"))
                    .first();

            if (doc == null) {
                System.out.println("No results found.");
            } else {
                System.out.println(doc.toJson());
            }

            try {
                Document documentToInsert = new Document("address", new Document("building", "56478")
                        .append("coord", Arrays.asList(-73.9068506, 40.6199034))
                        .append("rua", "Avenue U")
                        .append("zipcode", "11234"))
                        .append("localidade", "Brooklyn")
                        .append("gastronomia", "Portuguese")
                        .append("grades", Arrays.asList(
                                new Document("date", new Date(1401321600000L))
                                        .append("grade", "A")
                                        .append("score", 10),
                                new Document("date", new Date(1389657600000L))
                                        .append("grade", "A")
                                        .append("score", 10)
                        ))
                        .append("nome", "Tasco")
                        .append("restaurant_id", "36478");
                collection.insertOne(documentToInsert);
                System.out.println("Success! Inserted document id: " + documentToInsert);

            } catch (MongoException me) {
                System.err.println("Unable to insert due to an error: " + me);
            }



        } catch (MongoException e) {
            // Handle MongoDB-related exceptions here
            System.err.println("MongoDB Exception: " + e.getMessage());

        }
    }
}