package repositories;

import entities.Author;
import entities.Book;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.jetbrains.annotations.NotNull;

import java.util.LinkedList;
import java.util.List;

public class BookRepository extends AbstractRepository{

    @NotNull
    public List<Book> getAllByName(@NotNull String name) {
        updateCurrentSession();
        Transaction tx = session.beginTransaction();
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<Book> criteriaQuery = criteriaBuilder.createQuery(Book.class);
        Root<Book> root = criteriaQuery.from(Book.class);
        criteriaQuery.select(root).where(criteriaBuilder.equal(root.get("name"), name));
        Query<Book> query = session.createQuery(criteriaQuery);
        List<Book> books = query.getResultList();
        tx.commit();
        return books;
    }

    @NotNull
    public List<Book> getAllByAuthorName(@NotNull String name) {
        updateCurrentSession();
        Transaction tx = session.beginTransaction();
        List<Author> authors = session.createSelectionQuery("from Author a where a.name = :name", Author.class).setParameter("name", name).list();
        System.out.println(authors);
        List<Book> books = new LinkedList<>();
        for(Author author : authors){
            books.addAll(author.getBooks());
        }
        tx.commit();
        return books;
    }

}
