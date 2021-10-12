package modules.user.domain;

 import java.util.UUID;

public class User {

    private int userid;
    private String role;
    private String username;


    public User(){

    }
    public User(String username) {
        userid = 2;
        role = "user";
        this.username = username;
    }



//    UUID idOne = UUID.randomUUID();

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        userid = userid;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }


//    public static User setid(User userid){
//        if(userid.equals())
//
//    }
//
//    private boolean equals() {
//
//    }
}