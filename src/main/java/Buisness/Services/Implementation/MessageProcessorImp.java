package Buisness.Services.Implementation;

import Data.Entities.*;
import Data.Services.*;
import Data.Services.Implementations.MessageRepositoryImp;

import com.fasterxml.jackson.databind.ObjectMapper;

import Buisness.Services.MessageProcessor;

public class MessageProcessorImp implements MessageProcessor {
    private final ObjectMapper mapper = new ObjectMapper();
    private final MessageRepository repository = new MessageRepositoryImp();

    public void handleMessage(String json) {
        try {
            Message msg = mapper.readValue(json, Message.class);
            // Optional: validate timestamp or content here
            repository.save(msg);
            System.out.println("Saved message: " + msg.getContent());
        } catch (Exception e) {
            System.err.println("Error processing message: " + e.getMessage());
        }
    }
}