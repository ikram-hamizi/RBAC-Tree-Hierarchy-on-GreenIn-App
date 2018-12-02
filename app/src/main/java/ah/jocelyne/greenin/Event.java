package ah.jocelyne.greenin;

/**
 * Created by joc on 4/7/2018.
 */

public class Event {

    String img_url;
    String date;
    String day;
    String name;
    String location;
    String time;
    String description;

    public Event(String date, String day, String desc, String img, String location, String name, String time) {
        this.img_url = img;
        this.date = date;
        this.day = day;
        this.name = name;
        this.location = location;
        this.time = time;
        this.description = desc;
    }

    public String getImg_url() {
        return img_url;
    }

    public void setImg_url(String img_url) {
        this.img_url = img_url;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
