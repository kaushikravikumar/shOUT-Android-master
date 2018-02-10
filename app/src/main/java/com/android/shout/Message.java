package com.android.shout;

/**
 * Created by kaushikr on 2/1/18.
 */

public class Message {

    private String body;
    private String date;
    private String time;
    private String title;
    private String ID;

    public Message()
    {
        // NO ARGUMENT CONSTRUCTOR
    }

    public Message(String body, String date, String time, String title) {
        this.body = body;
        this.date = date;
        this.title = title;
        this.time = time;
    }
    public void setID(String ID)
    {
        this.ID = ID;
    }
    public String getID()
    {
        return ID;
    }
    public String getBody()
    {
        return body;
    }
    public String getDate()
    {
        return date;
    }
    public String getTitle()
    {
        return title;
    }
    public String getTime() {return time;}
}