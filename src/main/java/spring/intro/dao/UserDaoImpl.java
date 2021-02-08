package spring.intro.dao;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import spring.intro.model.User;

public class UserDaoImpl implements UserDao {
    @Override
    public void add(User user) {
        Transaction transaction = null;
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            session.save(user);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new RuntimeException("Can't insert user entity: "
                    + user, e);
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public List<User> listUsers() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("select u from User u", User.class)
                    .getResultList();
        } catch (Exception e) {
            throw new RuntimeException("Couldn't get list of users", e);
        }
    }
}
