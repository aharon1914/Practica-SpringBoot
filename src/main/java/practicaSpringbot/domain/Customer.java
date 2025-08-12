package practicaSpringbot.domain;

public class Customer {

    //atributos clase tipo pojo   "" POJO ""
    private int id;
    private String name;
    private String userName;
    private String lastName;
    private String password;
    

    //constructor
    public Customer(int id , String name , String userName , String password, String lastName){
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.userName = userName;
        this.password = password;
        
    }

    //SET  and  GET

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


}
