package model;

import java.io.Serializable;
import java.util.Date;

public class Note implements INote, Serializable {
    private String title;
    private String content;
    private Date date;

    public Note(String title, String content, Date date) {
        this.title = title;
        this.content = content;
        this.date = date;
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public String getContent() {
        return content;
    }

    @Override
    public Date getDate() {
        return date;
    }
}
