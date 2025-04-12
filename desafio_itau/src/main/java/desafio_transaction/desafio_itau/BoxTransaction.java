package desafio_transaction.desafio_itau;

import java.time.Duration;
import java.time.OffsetDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BoxTransaction {

    private List<Transaction> transactions = new ArrayList<>();

    public void appendTransaction(Transaction transaction){
        transactions.add(transaction);
    }

    public List<Transaction> getLastTransactions() {

        Date date_now = new Date();

        return transactions.stream()
                .filter(t ->
                        (date_now.getTime() -
                         Date.from(OffsetDateTime.parse(
                         t.getDataHora()).toInstant()).getTime()) / 1000 <= 60
                ).toList();
    }
}
