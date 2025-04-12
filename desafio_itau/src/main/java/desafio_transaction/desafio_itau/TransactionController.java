package desafio_transaction.desafio_itau;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

        StatisticsTransaction st = new StatisticsTransaction(box_transaction.getLastTransactions());

        return ResponseEntity.ok(st);

    }

}
