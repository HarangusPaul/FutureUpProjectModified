package ro.zynk.futureup.domain.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import ro.zynk.futureup.domain.dtos.Transaction;

import java.util.List;
import java.util.Optional;


@Repository
public interface TransactionRepository extends PagingAndSortingRepository<Transaction,Long> {
    List<Transaction> findAll(); //returns a list of all transactions

    Optional<Transaction> findById(Transaction transaction);
}
