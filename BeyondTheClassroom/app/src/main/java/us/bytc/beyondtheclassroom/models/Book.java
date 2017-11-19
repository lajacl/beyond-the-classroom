package us.bytc.beyondtheclassroom.models;

public class Book {
    //@JsonProperty("title")
    private String title;
    //@JsonProperty("Page")
    private int pageCount;
    //@JsonProperty("id")
    private String id;
    //@JsonProperty("etag")
    private String etag;
    //@JsonProperty("selfLink")
    private String selfLink;
    //@JsonProperty("authors")
    private String author;
    //@JsonProperty("publisher")
    private String publisher;
    //@JsonProperty("publishedDate")
    private String publishedDate;
    //@JsonProperty("image_url")
    private String imageLink;
    private String webReaderLink;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEtag() {
        return etag;
    }

    public void setEtag(String etag) {
        this.etag = etag;
    }

    public String getSelfLink() {
        return selfLink;
    }

    public void setSelfLink(String selfLink) {
        this.selfLink = selfLink;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getPublishedDate() {
        return publishedDate;
    }

    public void setPublishedDate(String publishedDate) {
        this.publishedDate = publishedDate;
    }

    public String getImageLink() {
        return imageLink;
    }

    public void setImageLink(String imageLink) {
        this.imageLink = imageLink;
    }

    public String getWebReaderLink() {
        return webReaderLink;
    }

    public void setWebReaderLink(String webReaderLink) {
        this.webReaderLink = webReaderLink;
    }
}


