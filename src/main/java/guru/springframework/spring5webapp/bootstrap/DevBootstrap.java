package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.model.Author;
import guru.springframework.spring5webapp.model.Book;
import guru.springframework.spring5webapp.repositories.AuthorRepository;
import guru.springframework.spring5webapp.repositories.BookRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private AuthorRepository authorRepository;
    private BookRepository bookRepository;

    public DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    private void initData() {

        // Eric
        Author eric = new Author(
                "Eric",
                "Evans"
        );
        Book sherlock = new Book(
                "Sherlock 3",
                "1234",
                "Newyork Time"
        );
        eric.getBooks().add(sherlock);
        sherlock.getAuthors().add(eric);

        authorRepository.save(eric);
        bookRepository.save(sherlock);

        // Beck
        Author beck = new Author(
                "Beck",
                "King"
        );
        Book doremon = new Book(
                "Doremon 4",
                "222",
                "Chibi"
        );
        beck.getBooks().add(doremon);
        doremon.getAuthors().add(beck);

        authorRepository.save(beck);
        bookRepository.save(doremon);

    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }
}
