package proj;

import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.hibernate.Session;
import java.util.List;

public class manageractions implements managerdao {
    Session session = currentsession.createsession();

    @Override
    public List<reimbursement> viewstatus() {
        Query query = session.createQuery("from reimbursement");
        return query.getResultList();
    }

    @Override
    public List<Employee> viewall() {
        Query query = session.createQuery("from Employee");
        return query.getResultList();
    }

    @Override
    public List<reimbursement> vieweach(String username) {
        Query query = session.createQuery("from reimbursement where username='"+username+"'");
        return query.getResultList();
    }

    @Override
    public void approveselected(int[] ids) {
        Transaction t = session.beginTransaction();
        for (int each : ids) {
            Query query = session.createQuery("update reimbursement set status = 'approved' where id="+each+"");
            query.executeUpdate();
        }
        t.commit();
    }

    @Override
    public void denyselected(int[] ids) {
        Transaction t = session.beginTransaction();
        for (int each : ids) {
            Query query = session.createQuery("update reimbursement set status = 'denied' where id="+each+"");
            query.executeUpdate();
        }
        t.commit();
    }


}
