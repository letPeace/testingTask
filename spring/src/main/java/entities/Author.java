package entities;

import jakarta.persistence.*;
import org.jetbrains.annotations.NotNull;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="author", uniqueConstraints = {@UniqueConstraint(columnNames = {"id"})})
public class Author implements Serializable {
        @Id
        @GeneratedValue(strategy=GenerationType.IDENTITY)
        @Column(name = "id", nullable = false, unique = true, length = 11)
        @NotNull
        private Integer id;
        @Column(name = "name", nullable = false)
        @NotNull
        private String name;
        @NotNull
        @ManyToMany(mappedBy = "authors")
        private Set<Book> books;
        public Author(){
                this.id = -1;
                this.name = "SEED_DATA";
                this.books = new HashSet<>();
        }
        public Author(@NotNull String name){
                this.id = -1;
                this.name = name;
                this.books = new HashSet<>();
        }
        public void addBook(@NotNull Book book){books.add(book);}

        @NotNull
        public Integer getId() {
                return id;
        }
        public void setId(@NotNull Integer id) {
                this.id = id;
        }
        @NotNull
        public String getName() {
                return name;
        }
        public void setName(@NotNull String name) {
                this.name = name;
        }
        @NotNull
        public Set<Book> getBooks() {
                return books;
        }
        public void setBooks(@NotNull Set<Book> books) {
                this.books = books;
        }
        @Override
        public String toString() {
                return "Author{" +
                        "id=" + id +
                        ", name='" + name + '\'' +
                        '}';
        }
}
