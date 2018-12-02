package ah.jocelyne.greenin;

public class Video {
    String title;
    String img_url;
    String vid_url;

    public Video(String title, String img_url, String vid_url) {
        this.title = title;
        this.img_url = img_url;
        this.vid_url = vid_url;
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

    public String getVid_url() {
        return vid_url;
    }

    public void setVid_url(String vid_url) {
        this.vid_url = vid_url;
    }
}
