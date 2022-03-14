package proj;

import java.util.List;

public interface employeedao {

    void update(String username, String name, String email, String gender, String country);
    //void view();

    void updatestatus(String username, String name, String date, int amount);

    List<Employee> view(String username);

    List<reimbursement> viewstatus(String username);

}
