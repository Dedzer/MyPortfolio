package project.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import project.dao.StudiesDao;
import project.model.Studies;


import java.io.PrintStream;
import java.util.List;

public class StudiesDaoImpl implements StudiesDao {
    private final SessionFactory sessionFactory;

    public StudiesDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<Studies> findAll(){
        Session session = this.sessionFactory.openSession();
        Throwable throwable = null;
        List list;
        try {
            List<Studies> studiesList = session.createQuery("from Studies", Studies.class).list();
            studiesList.forEach(System.out::println);
            list = studiesList;
        } catch (Throwable t){
            throwable = t;
            throw t;
        } finally {
            if (session != null){
                if (throwable != null){
                    try {
                        session.close();
                    } catch (Throwable t){
                        throwable.addSuppressed(t);
                    }
                } else {
                    session.close();
                }
            }
        }
        return list;
    }
    @Override
    public Studies getDescriptionByName(String name){
        Session session = this.sessionFactory.openSession();
        Throwable throwable = null;
        Studies studies;
        try {
            Query<Studies> query = session.createNamedQuery("select description from studies where name = '" + name + "'", Studies.class);
            studies = query.getSingleResult();
        } catch (Throwable t){
            throwable = t;
            throw t;
        } finally {
            if (session != null){
                if (throwable != null){
                    try {
                        session.close();
                    } catch (Throwable t){
                        throwable.addSuppressed(t);
                    }
                } else {
                    session.close();
                }
            }
        }
        return studies;
    }
}
