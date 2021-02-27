package br.com.ivanfsilva.libraryapi.service.impl;

import br.com.ivanfsilva.libraryapi.api.exception.BusinessException;
import br.com.ivanfsilva.libraryapi.model.entity.Loan;
import br.com.ivanfsilva.libraryapi.model.repository.LoanRepository;
import br.com.ivanfsilva.libraryapi.service.LoanService;

import java.util.Optional;

public class LoanServiceImpl implements LoanService {

    private LoanRepository repository;

    public LoanServiceImpl(LoanRepository repository) {
        this.repository = repository;
    }

    @Override
    public Loan save(Loan loan) {
        if ( repository.existsByBookAndNotReturned(loan.getBook()) ) {
            throw new BusinessException("Book already loaned");
        }
        return repository.save(loan);
    }

    @Override
    public Optional<Loan> getById(Long id) {
        return Optional.empty();
    }

    @Override
    public Loan update(Loan loan) {
        return null;
    }
}
