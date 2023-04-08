package ro.zynk.futureup.controllers.responses;

import ro.zynk.futureup.domain.dtos.Transaction;

import java.util.List;

public class ListOfTransactionsResponse extends BaseResponse {
    private List<Transaction> allTransactions;

//    -methods:
    public ListOfTransactionsResponse(List<Transaction> allTransactions) {
        this.allTransactions = allTransactions;
    }

    public List<Transaction> getAllTransactions() {
        return allTransactions;
    }

    public void setAllTransactions(List<Transaction> allTransactions) {
        this.allTransactions = allTransactions;
    }

}
