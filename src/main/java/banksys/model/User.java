package banksys.model;

public class User {
    private String user_no;
    private int status;
    private String name;
    private String password;
    private String owner_id_card;

    // 构造函数
    public User(String user_no, int status, String name, String password, String owner_id_card) {
        this.user_no = user_no;
        this.status = status;
        this.name = name;
        this.password = password;
        this.owner_id_card = owner_id_card;
    }

    // 默认构造函数
    public User() {}

    // Getter 和 Setter 方法
    public String getUserNo() {
        return user_no;
    }

    public void setUserNo(String user_no) {
        this.user_no = user_no;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getOwnerIdCard() {
        return owner_id_card;
    }

    public void setOwnerIdCard(String owner_id_card) {
        this.owner_id_card = owner_id_card;
    }

    @Override
    public String toString() {
        return "User{" +
                "user_no='" + user_no + '\'' +
                ", status=" + status +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", owner_id_card='" + owner_id_card + '\'' +
                '}';
    }
}



