package project;

import project.model.Rate;
import project.model.Skills;
import project.model.Studies;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import java.util.Properties;

public class HibernateJavaConfig implements HibernateConfig{

    private static SessionFactory sessionFactory;
    private static ServiceRegistry serviceRegistry;

    @Override
    public SessionFactory getSessionFactory(){
        if(sessionFactory == null){
            try {
                Configuration configuration = new Configuration();
                Properties settings = new Properties();
                settings.put(Environment.DRIVER, "com.mysql.jdbc.Driver");
                settings.put(Environment.URL, "jdbc:mysql://localhost:3306/aboutme?allowPublicKeyRetrieval=true&useSSL=false");
                settings.put(Environment.USER, "test");
                settings.put(Environment.PASS, "test");
                settings.put(Environment.DIALECT, "org.hibernate.dialect.MySQL5Dialect");
                settings.put(Environment.SHOW_SQL, "true");
                settings.put(Environment.FORMAT_SQL, "true");
                settings.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");
                configuration.setProperties(settings);
                configuration.addAnnotatedClass(Studies.class);
                configuration.addAnnotatedClass(Skills.class);
                configuration.addAnnotatedClass(Rate.class);
                serviceRegistry = new StandardServiceRegistryBuilder()
                        .applySettings(configuration.getProperties())
                        .build();
                sessionFactory = configuration.buildSessionFactory(serviceRegistry);
            } catch (Exception e){
                e.printStackTrace();
            }
        }
        return sessionFactory;
    }
    @Override
    public void shutdown(){
        StandardServiceRegistryBuilder.destroy(serviceRegistry);
    }
}
