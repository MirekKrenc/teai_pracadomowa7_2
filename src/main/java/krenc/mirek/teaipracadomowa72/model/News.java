package krenc.mirek.teaipracadomowa72.model;

public class News {

    private String author;
    private String title;
    private String description;
    private String url;
    private String urlToImage;

    //String sql = "create table news (author varchar(50), title varchar(500), description varchar(1000), url varchar(200), url_to_image varchar(500))";
    public News(String author, String title, String description, String url, String urlToImage) {
        if (author != null) this.author = author.substring(0, Math.min(author.length(), 50));
        if (title != null) this.title = title.substring(0, Math.min(title.length(), 500));
        if (description != null ) this.description = description.substring(0, Math.min(description.length(), 1000));
        this.url = url;
        this.urlToImage = urlToImage;
    }

    public News() {
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUrlToImage() {
        return urlToImage;
    }

    public void setUrlToImage(String urlToImage) {
        this.urlToImage = urlToImage;
    }

    @Override
    public String toString() {
        return "News{" +
                "author='" + author + '\'' +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", url='" + url + '\'' +
                ", urlToImage='" + urlToImage + '\'' +
                '}';
    }
}
