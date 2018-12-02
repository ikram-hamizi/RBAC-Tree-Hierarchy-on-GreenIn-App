package ah.jocelyne.greenin;

public class Market {
    String address;
    String description;
    String img_url;
    String location_url;
    String name;

    public Market(String address, String description, String img_url, String location_url, String name) {
        this.address = address;
        this.description = description;
        this.img_url = img_url;
        this.location_url = location_url;
        this.name = name;
    }

    public String getImg_url() {
        return img_url;
    }

    public void setImg_url(String img_url) {
        this.img_url = img_url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getLocation_url() {
        return location_url;
    }

    public void setLocation_url(String location_url) {
        this.location_url = location_url;
    }
}
