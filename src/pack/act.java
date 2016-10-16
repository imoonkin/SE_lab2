package pack;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletRequest;
import java.rmi.server.ExportException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class act extends ActionSupport{
    private String Name,Country,delete_Isbn,delete_Name;
    private ResultSet resultSet = null;
    private List<item> itemList;
    private int AuthorID,Age;//asasaaa



    public int getAuthorID(){
        return AuthorID;
    }

    public void setAuthorID(int a){
        this.AuthorID=a;
    }

    public int getAge() {
        return Age;
    }

    public void setAge(int n){
        this.Age=n;
    }

    public String getName() {
        return Name;
    }

    public void setName(String n){
        this.Name=n;
    }

    public String getCountry() {
        return Country;
    }

    public void setCountry(String n){
        this.Country=n;
    }

    private String getDelete_Isbn() {
        return delete_Isbn;
    }

    public void setDelete_Isbn(String n){
        this.delete_Isbn=n;
    }


    public String store()throws Exception{
        SqlAccess db_access=new SqlAccess();
        db_access.readDataBase();
        db_access.store(AuthorID,Name,Age,Country);
        resultSet=db_access.viewTotal();
        itemList=db_access.update_list(resultSet);
        HttpServletRequest request = ServletActionContext.getRequest();
        request.setAttribute("itemlist", itemList);
        db_access.close();
        return SUCCESS;
    }
    public String view()throws Exception{
        SqlAccess db_access=new SqlAccess();
        db_access.readDataBase();
        resultSet=db_access.viewTotal();
        itemList=db_access.update_list(resultSet);
        HttpServletRequest request = ServletActionContext.getRequest();
        request.setAttribute("itemlist", itemList);
        db_access.close();
        return SUCCESS;
    }
    public String returnHome(){
        return SUCCESS;
    }
    public String delete()throws Exception{
        SqlAccess db_access=new SqlAccess();
        db_access.readDataBase();
        int aAuthorID=db_access.isbn_to_id(delete_Isbn);
        String aName=db_access.id_to_name(aAuthorID);
        db_access.delete(delete_Isbn);
        resultSet=db_access.select_name(aName);
        resultSet.next();
        aAuthorID=resultSet.getInt(1);
        aName=resultSet.getString(2);
        int aAge=resultSet.getInt(3);
        String aCountry=resultSet.getString(4);

        resultSet=db_access.searchbook(aAuthorID);
        itemList=db_access.update_list(resultSet);
        HttpServletRequest request = ServletActionContext.getRequest();
        request.setAttribute("itemlist", itemList);
        request.setAttribute("aAuthorID",aAuthorID);
        request.setAttribute("aName",aName);
        request.setAttribute("aAge",aAge);
        request.setAttribute("aCountry",aCountry);
        db_access.close();
        return SUCCESS;
    }
    public String search()throws Exception{
        try {
            //change aa
            SqlAccess db_access=new SqlAccess();
            db_access.readDataBase();
            resultSet = db_access.select_name(Name);
            resultSet.next();
            int aAuthorID=resultSet.getInt(1);
            String aName=resultSet.getString(2);
            int aAge=resultSet.getInt(3);
            String aCountry=resultSet.getString(4);
            resultSet=db_access.searchbook(aAuthorID);
            itemList=db_access.update_list(resultSet);
            HttpServletRequest request = ServletActionContext.getRequest();
            request.setAttribute("itemlist", itemList);
            request.setAttribute("aAuthorID",aAuthorID);
            request.setAttribute("aName",aName);
            request.setAttribute("aAge",aAge);
            request.setAttribute("aCountry",aCountry);
            return SUCCESS;
        }catch (Exception e) {
            return ERROR;
        }
    }

}