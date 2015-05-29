package org.darcstarsolutions.ironworker.mongodb;

import io.iron.ironworker.client.Client;
import io.iron.ironworker.client.builders.Params;
import org.darcstarsolutions.ironworker.mongodb.configuration.TimeStampRepository;
import org.darcstarsolutions.ironworker.mongodb.entities.TimeStamp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

/**
 * Created by mharris on 5/27/15.
 */

@SpringBootApplication
public class Application implements CommandLineRunner {

    @Autowired
    private TimeStampRepository repository;

    @Autowired
    private Client client;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        List<TimeStamp> timeStamps = repository.findAll();
        for (TimeStamp timeStamp : timeStamps) {
            if (!timeStamp.isRead()) {
                String id = timeStamp.getId().toString(16);
                System.out.println("Id: " + id);
                System.out.println(timeStamp.toString());
                client.createTask("mongodb-reader", Params.add("id", id));

            }
        }
    }
}
