package br.com.ivanfsilva.libraryapi.service;

import br.com.ivanfsilva.libraryapi.api.dto.LoanFilterDTO;
import br.com.ivanfsilva.libraryapi.model.entity.Book;
import br.com.ivanfsilva.libraryapi.model.entity.Loan;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface LoanService {
    Loan save(Loan loan);

    Optional<Loan> getById(Long id);

    Loan update(Loan loan);

    Page<Loan> find(LoanFilterDTO filterDTO, Pageable pageable);

    Page<Loan> getLoansByBook(Book book, Pageable pageable);

    List<Loan> getAllLateLoans();
}
