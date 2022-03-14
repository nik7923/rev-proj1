package proj;

import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;


public class employeeaction implements employeedao{
    Session session = currentsession.createsession();

    public void createacc(String username, String password) {
        Transaction t = session.beginTransaction();
        users user = new users();
        user.setUsername(username);
        user.setPassword(password);
        session.persist(user);
        t.commit();
    }

    public boolean checklogin(String username, String password) {
        Query query = session.createQuery("select password from users where username='"+username+"'");
        String pass = (String) query.getSingleResult();
        if (password.equals(pass)) {
            return true;
        }
        else {
            return false;
        }
    }

    @Override
    public void update(String username, String name, String email, String gender, String country) {
        Transaction t = session.beginTransaction();
        Employee employee = new Employee();
        employee.setUsername(username);
        employee.setName(name);
        employee.setEmail(email);
        employee.setGender(gender);
        employee.setCountry(country);

        session.saveOrUpdate(employee);
        t.commit();


    }

    @Override
    public List<Employee> view(String user) {
        Query query = session.createQuery("from Employee where username='"+user+"'");
        return query.getResultList();

    }

    @Override
    public void updatestatus(String username, String name, String date, int amount) {
        Transaction t = session.beginTransaction();
        reimbursement claim = new reimbursement();
        claim.setUsername(username);
        claim.setName(name);
        claim.setDate(date);
        claim.setAmount(amount);
        session.saveOrUpdate(claim);
        t.commit();
    }

    @Override
    public List<reimbursement> viewstatus(String user) {
        Query query = session.createQuery("from reimbursement where username='"+user+"'");
        return query.getResultList();

    }
}
