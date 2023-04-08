package ro.zynk.futureup.domain.dtos;


import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "transactions")
public class Transaction extends BaseEntity{

    @Column
    private LocalDate dateOfTransaction;

    @Column
    private Double price;

    @Column
    private Double amount; //sorry for my english skills :)

    @OneToOne
    @JoinColumn(name = "coin_id")
    private Coin coin;

    ///I would have linked it to a wallet_id for you to know in which wallet the transaction was made but because of the task I did not do it like that
    ///That would have been it another relation OneToOne bcs it's 1 wallet and 1 transaction

    ///Methods Constructor`s:
    public Transaction() {
    }

    public Transaction(LocalDate dateOfTransaction, Double price, Double amount, Coin coin) {
        this.dateOfTransaction = dateOfTransaction;
        this.price = price;
        this.amount = amount;
        this.coin = coin;
    }

    public Transaction(Transaction transaction) {
        this.amount = transaction.amount;
        this.coin = transaction.coin;
        this.dateOfTransaction = transaction.dateOfTransaction;
        this.price = transaction.price;
    }

    ///Getters and Setters:
     public LocalDate getDateOfTransaction() {
            return dateOfTransaction;
        }

        public void setDateOfTransaction(LocalDate dateOfTransaction) {
            this.dateOfTransaction = dateOfTransaction;
        }

        public Double getPrice() {
            return price;
        }

        public void setPrice(Double price) {
            this.price = price;
        }

        public Double getAmount() {
            return amount;
        }

        public void setAmount(Double amount) {
            this.amount = amount;
        }

        public Coin getCoin() {
            return coin;
        }

        public void setCoin(Coin coin) {
            this.coin = coin;
        }
        ///Other methods: None yet necessary...
}
