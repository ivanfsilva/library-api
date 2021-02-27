package br.com.ivanfsilva.libraryapi.service;

import br.com.ivanfsilva.libraryapi.api.resource.BookController;
import br.com.ivanfsilva.libraryapi.model.entity.Loan;

import java.util.Optional;

public interface LoanService {
    Loan save(Loan loan);

    Optional<Loan> getById(Long id);

    Loan update(Loan loan);
}
