package br.com.ivanfsilva.libraryapi.model.repository;

import br.com.ivanfsilva.libraryapi.model.entity.Book;
import br.com.ivanfsilva.libraryapi.model.entity.Loan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface LoanRepository extends JpaRepository<Loan, Long> {

    @Query(value = " SELECT CASE WHEN ( COUNT(l.id) > 0 )  THEN TRUE ELSE false END " +
            " FROM Loan l WHERE  l.book = :book AND ( l.returned IS NULL OR l.returned IS FALSE ) ")
    boolean existsByBookAndNotReturned( @Param("book") Book book );
}
