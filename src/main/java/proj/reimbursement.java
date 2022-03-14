package proj;

import jakarta.persistence.*;
import org.hibernate.annotations.ColumnDefault;

@Entity
public class reimbursement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String date;
    private String username;
    private String name="";
    private int amount;
    @Enumerated(EnumType.STRING)
    private appstatus status = appstatus.pending;

    public reimbursement() {}

    public reimbursement(String date, String username, String name, int amount, appstatus status) {
        this.date = date;
        this.status = status;
        this.amount = amount;
        this.username = username;
        this.name=name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public appstatus getStatus() {
        return status;
    }

    public void setStatus(appstatus status) {
        this.status = status;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

enum appstatus {
    pending, approved, denied;
}
