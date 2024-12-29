package appcr.adminpc.chatbotapp;

public class Message {
    public static String SEND = "user";
    public static String GET = "bot";

    String message;
    String sendBy;
    String time;

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getSendBy() {
        return sendBy;
    }

    public void setSendBy(String sendBy) {
        this.sendBy = sendBy;
    }

    public Message(String message, String sendBy) {
        this.message = message;
        this.sendBy = sendBy;
        this.time = time;
    }
}
