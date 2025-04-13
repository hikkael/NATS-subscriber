package API;

import io.nats.client.Connection;
import io.nats.client.Nats;
import io.nats.client.Dispatcher;
import java.io.IOException;
import java.nio.charset.StandardCharsets;


public class Main {
  public static void main(String[] args) {
    String natsURL = System.getenv("NATS_URL");
    if (natsURL == null) {
        natsURL = "nats://127.0.0.1:4222";
    }


    try (Connection nc = Nats.connect(natsURL)) {
      
        Dispatcher dispatcher = nc.createDispatcher((msg) -> {
            System.out.printf("%s on subject %s\n",
                new String(msg.getData(), StandardCharsets.UTF_8),
                msg.getSubject());
        });
        
        dispatcher.subscribe("messages");
        Thread.sleep(200);


    } catch (InterruptedException | IOException e) {
      e.printStackTrace();
    }
  }
}