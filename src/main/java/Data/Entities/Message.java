package Data.Entities;


public class Message {

    private String content;
    //private String timestamp;

    public Message() {} // required for Jackson

    public String getContent() { return content; }
    public void setContent(String content) { this.content = content; }

    //public String getTimestamp() { return timestamp; }
    //public void setTimestamp(String timestamp) { this.timestamp = timestamp; }

}
