package repositories;

import entities.Author;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class AuthorRepository extends AbstractRepository{

    @NotNull
    public List<Author> getAllByName(@NotNull String name) {
        updateCurrentSession();
        Transaction tx = session.beginTransaction();
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<Author> criteriaQuery = criteriaBuilder.createQuery(Author.class);
        Root<Author> root = criteriaQuery.from(Author.class);
        criteriaQuery.select(root).where(criteriaBuilder.equal(root.get("name"), name));
        Query<Author> query = session.createQuery(criteriaQuery);
        List<Author> authors = query.getResultList();
        tx.commit();
        return authors;
    }

    @NotNull
    public List<Author> getAllByIdRange(@NotNull Integer idStart, @NotNull Integer idEnd) {
        updateCurrentSession();
        Transaction tx = session.beginTransaction();
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<Author> criteriaQuery = criteriaBuilder.createQuery(Author.class);
        Root<Author> root = criteriaQuery.from(Author.class);
        criteriaQuery.select(root).where(criteriaBuilder.between(root.get("id"), idStart, idEnd));
        Query<Author> query = session.createQuery(criteriaQuery);
        List<Author> authors = query.getResultList();
        tx.commit();
        return authors;
    }

    @NotNull
    public List<Author> getAllDistinct() {
        updateCurrentSession();
        Transaction tx = session.beginTransaction();
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<Author> criteriaQuery = criteriaBuilder.createQuery(Author.class);
        Root<Author> root = criteriaQuery.from(Author.class);
        criteriaQuery.multiselect(root.get("name")).groupBy(root.get("name"));
        Query<Author> query = session.createQuery(criteriaQuery);
        List<Author> authors = query.getResultList();
        tx.commit();
        return authors;
    }

}
