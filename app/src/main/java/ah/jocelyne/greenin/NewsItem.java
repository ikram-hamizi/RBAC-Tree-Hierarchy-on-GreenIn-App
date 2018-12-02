package ah.jocelyne.greenin;

public class NewsItem {
    String title;
    String img_url;
    String url;

    public NewsItem(String title, String img_url, String url) {
        this.title = title;
        this.img_url = img_url;
        this.url = url;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImg_url() {
        return img_url;
    }

    public void setImg_url(String img_url) {
        this.img_url = img_url;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
