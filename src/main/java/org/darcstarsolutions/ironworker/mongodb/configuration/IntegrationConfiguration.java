package org.darcstarsolutions.ironworker.mongodb.configuration;

import io.iron.ironworker.client.Client;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by mharris on 5/27/15.
 */

@Configuration
public class IntegrationConfiguration {

    @Bean
    public Client client() {
        return new Client("2L8sQ7unT2tA4NIU1lAARHz3DPs", "555aa4533c824c000600001a");
    }


}
