package br.com.ivanfsilva.libraryapi.model.repository;

import br.com.ivanfsilva.libraryapi.model.entity.Book;
import br.com.ivanfsilva.libraryapi.model.entity.Loan;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface LoanRepository extends JpaRepository<Loan, Long> {

    @Query(value = " SELECT CASE WHEN ( COUNT(l.id) > 0 )  THEN TRUE ELSE false END " +
            " FROM Loan l WHERE l.book = :book AND ( l.returned IS NULL OR l.returned IS FALSE ) ")
    boolean existsByBookAndNotReturned( @Param("book") Book book );

    @Query( value = " SELECT l FROM Loan AS l JOIN l.book AS b WHERE b.isbn = :isbn OR l.customer = :customer" )
    Page<Loan> findByBookIsbnOrCustomer(
            @Param("isbn") String isbn,
            @Param("customer") String customer,
            Pageable pageable);

    Page<Loan> findByBook(Book book, Pageable pageable);

    @Query( value = " SELECT l FROM Loan l WHERE l.loanDate <= :threeDaysAgo AND ( l.returned IS NULL OR l.returned IS FALSE ) ")
    List<Loan> findByLoanDateLessThanAndNotReturned( @Param("threeDaysAgo") LocalDate threeDaysAgo);
}
