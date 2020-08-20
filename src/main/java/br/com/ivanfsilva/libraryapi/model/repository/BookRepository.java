package br.com.ivanfsilva.libraryapi.model.repository;

import br.com.ivanfsilva.libraryapi.model.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}
