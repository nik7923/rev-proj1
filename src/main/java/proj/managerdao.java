package proj;

import java.util.List;

public interface managerdao {
    List<reimbursement> viewstatus();
    List<Employee> viewall();
    List<reimbursement> vieweach(String username);
    void approveselected(int[] ids);
    void denyselected(int[] ids);
}
