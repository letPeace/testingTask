import configurations.HibernateConfig;
import entities.Author;
import entities.Book;
import org.hibernate.Session;
import repositories.AuthorRepository;
import repositories.BookRepository;

public class Application {

    public static void main(String[] args){

        /*
        create entities
         */

        Book book1 = new Book();
        book1.setName("bookName");
        Book book2 = new Book();
        book2.setName("bookNameNew");
        Author author1 = new Author();
        author1.setName("authorName1");
        Author author2 = new Author();
        author2.setName("authorName2");
        Author author3 = new Author();
        author3.setName("authorName1");
        book1.addAuthor(author1);
        book1.addAuthor(author2);
        book2.addAuthor(author3);

        /*
        load seed data
         */

        Session session = HibernateConfig.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        session.save(book1);
        session.save(book2);
        session.save(author1);
        session.save(author2);
        session.save(author3);
        session.getTransaction().commit();

        /*
        create repositories
         */

        BookRepository bookRepository = new BookRepository();
        AuthorRepository authorRepository = new AuthorRepository();
        // query 1.book
        System.out.println("query 1.book");
        System.out.println(bookRepository.getAllByName("bookName"));
        // query 1.author
        System.out.println("query 1.author");
        System.out.println(authorRepository.getAllByName("authorName1"));
        // query 2
        System.out.println("query 2");
        System.out.println(authorRepository.getAllByIdRange(1, 3));
        // query 3
        System.out.println("query 3");
        System.out.println(authorRepository.getAllDistinct());
        // query 4
        System.out.println("query 4");
        System.out.println(bookRepository.getAllByAuthorName("authorName1"));

        /*
        close session
         */

        session.close();

    }

}
