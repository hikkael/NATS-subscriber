package Data.Entities;

import java.sql.Date;

public class Message {

    private String messageText;
    private Date date;

    public Message(){}

    public String getmessageText(){
        return messageText;
    }

    public Date getDate() {
        return date;
    }

}