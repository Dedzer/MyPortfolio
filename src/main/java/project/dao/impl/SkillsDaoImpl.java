package project.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import project.dao.SkillsDao;
import project.model.Skills;
import project.model.Studies;

import java.util.List;

public class SkillsDaoImpl implements SkillsDao {
    private final SessionFactory sessionFactory;

    public SkillsDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<Skills> findAll(){
        Session session = this.sessionFactory.openSession();
        Throwable throwable = null;
        List list;
        try {
            List<Skills> skillsList = session.createQuery("from Skills", Skills.class).list();
            skillsList.forEach(System.out::println);
            list = skillsList;
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
}
