package repositories;

import configurations.HibernateConfig;
import org.hibernate.Session;

public abstract class AbstractRepository {
    protected Session session;
    protected AbstractRepository(Session session){this.session = session;}
    protected AbstractRepository(){
        this(getCurrentSession());
    }
    protected static Session getCurrentSession(){return HibernateConfig.getSessionFactory().getCurrentSession();}
    protected void updateCurrentSession(){this.session = getCurrentSession();}
}
