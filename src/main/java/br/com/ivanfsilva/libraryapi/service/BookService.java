package br.com.ivanfsilva.libraryapi.service;

import br.com.ivanfsilva.libraryapi.model.entity.Book;
import org.springframework.stereotype.Service;

@Service
public interface BookService {
    Book save(Book book);
}
