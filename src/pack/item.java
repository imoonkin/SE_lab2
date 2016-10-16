package pack;

public class item {
    private String Isbn=null;
    private String Title=null;
    private int AuthorID;
    private String Publisher=null;
    private String PublishDate=null;
    private String Price=null;
    public item(String Isbn,String Title,int AuthorID,String Publisher,String PublishDate,String Price){
        super();
        this.Isbn=Isbn;
        this.Title=Title;
        this.AuthorID=AuthorID;
        this.Publisher=Publisher;
        this.PublishDate=PublishDate;
        this.Price=Price;

    }
    public String getIsbn(){
        return Isbn;
    }
    public void setIsbn(String Isbn){
        this.Isbn=Isbn;
    }
    public String getTitle(){
        return Title;
    }
    public void setTitle(String Title){
        this.Title=Title;
    }
    public int getAuthorID(){
        return AuthorID;
    }
    public void setAuthorID(int AuthorID){
        this.AuthorID=AuthorID;
    }
    public String getPublisher(){
        return Publisher;
    }
    public void setPublisher(String Publisher){
        this.Publisher=Publisher;
    }
    public String getPublishDate(){
        return PublishDate;
    }
    public void setPublishDate(String PublishDate){
        this.PublishDate=PublishDate;
    }
    public String getPrice(){
        return Price;
    }
    public void setPrice(String Price){
        this.Price=Price;
    }
}
