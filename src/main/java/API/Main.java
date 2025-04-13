package API;

import io.nats.client.Connection;
import io.nats.client.Nats;
import io.nats.client.Dispatcher;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import Buisness.Services.*;
import Buisness.Services.Implementation.MessageProcessorImp;

public class Main {
  public static void main(String[] args) {

    MessageProcessor mProcessor = new MessageProcessorImp();


    try (Connection nc = Nats.connect("nats://localhost:4222")) {
      
        Dispatcher dispatcher = nc.createDispatcher((msg) -> {
                String json = new String(msg.getData(), StandardCharsets.UTF_8);
                mProcessor.handleMessage(json);
        });
        
        dispatcher.subscribe("messages.*");


        Thread.sleep(200);




    } catch (InterruptedException | IOException e) {
      e.printStackTrace();
    }
  }
}