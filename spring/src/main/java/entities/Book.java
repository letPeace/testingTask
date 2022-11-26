package entities;

import jakarta.persistence.*;
import org.jetbrains.annotations.NotNull;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="book", uniqueConstraints = {@UniqueConstraint(columnNames = {"id"})})
public class Book implements Serializable {
        @Id
        @GeneratedValue(strategy=GenerationType.IDENTITY)
        @Column(name = "id", nullable = false, unique = true, length = 11)
        @NotNull
        private Integer id;
        @Column(name = "name", nullable = false)
        @NotNull
        private String name;
        @NotNull
        @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.LAZY)
        private Set<Author> authors;
        public Book(){
                this.id = 0;
                this.name = "SEED_DATA";
                this.authors = new HashSet<>();
        }
        public void addAuthor(@NotNull Author author){
                authors.add(author);
                author.addBook(this);
        }

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
        public Set<Author> getAuthors() {
                return authors;
        }
        public void setAuthors(@NotNull Set<Author> authors) {
                this.authors = authors;
        }
        @Override
        public String toString() {
                return "Book{" +
                        "id=" + id +
                        ", name='" + name + '\'' +
                        '}';
        }
}
