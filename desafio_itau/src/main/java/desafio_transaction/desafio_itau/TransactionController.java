package desafio_transaction.desafio_itau;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
public class TransactionController {

    private BoxTransaction box_transaction = new BoxTransaction();

    @PostMapping("/transacao")
    public ResponseEntity<Void> buildTransaction (
            @RequestBody Transaction transaction
    ) {

        ValidationTransaction validation = new ValidationTransaction();
        HttpStatus httpStatus;

        try {
            validation.validationTransactionRules(transaction);
            box_transaction.appendTransaction(transaction);
            httpStatus = HttpStatus.CREATED;
        } catch (Exception e) {
            httpStatus = HttpStatus.UNPROCESSABLE_ENTITY;
        }

        return ResponseEntity.status(httpStatus).build();
    }

    @GetMapping("/estatistica")
    public ResponseEntity<StatisticsTransaction> getStatistics(){

        System.out.println(new StatisticsTransaction().getAvg());

        List<Transaction> last_transactions = box_transaction.getLastTransactions();

        StatisticsTransaction st = last_transactions.isEmpty()
                ? new StatisticsTransaction()
                : new StatisticsTransaction(last_transactions);

        return ResponseEntity.ok(st);

    }

}
