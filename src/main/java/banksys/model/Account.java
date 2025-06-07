package banksys.model;

public class Account {
    private String account_no;
    private int status;
    private String opener_id;
    private int balance;
    private String manager_id;

    // Getter 和 Setter 方法
    public String getAccountNo() {
        return account_no;
    }

    public void setAccountNo(String account_no) {
        this.account_no = account_no;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getOpenerId() {
        return opener_id;
    }

    public void setOpenerId(String opener_id) {
        this.opener_id = opener_id;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public String getManagerId() {
        return manager_id;
    }

    public void setManagerId(String manager_id) {
        this.manager_id = manager_id;
    }

    @Override
    public String toString() {
        return "Account{" +
                "account_no='" + account_no + '\'' +
                ", status=" + status +
                ", opener_id='" + opener_id + '\'' +
                ", balance=" + balance +
                ", manager_id='" + manager_id + '\'' +
                '}';
    }
}



