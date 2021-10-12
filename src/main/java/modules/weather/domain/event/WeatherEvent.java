package modules.weather.domain.event;

import java.util.Date;

public class WeatherEvent {

    private int id;
    private Date dateTime;
    private Date createdAt;
    private String type;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDateTime() {
        return dateTime;
    }

    public void setDateTime(Date dateTime) {
        this.dateTime = dateTime;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public PictureData getPictureData() {
        return pictureData;
    }

    public void setPictureData(PictureData pictureData) {
        this.pictureData = pictureData;
    }

    public EventAttribute getEventAttribute() {
        return eventAttribute;
    }

    public void setEventAttribute(EventAttribute eventAttribute) {
        this.eventAttribute = eventAttribute;
    }

    private PictureData pictureData;
    private EventAttribute eventAttribute;

    public WeatherEvent(int id, Date dateTime, Date createdAt, String type){
        this.id= id;
        this.dateTime = dateTime;
        this.createdAt = createdAt;
        this.type = type;
    }

    public WeatherEvent(PictureData pictureData){
        super();
        this.pictureData = pictureData;
    }

    public WeatherEvent(EventAttribute eventAttribute){
        super();
        this.eventAttribute = eventAttribute;
    }



}
