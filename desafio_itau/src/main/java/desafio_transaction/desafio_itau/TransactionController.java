package desafio_transaction.desafio_itau;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class TransactionController {

    @PostMapping
    public ResponseEntity<Void> buildTransaction (
            @RequestBody Transaction transaction
    ) {

        ValidationTransaction validation = new ValidationTransaction();
        HttpStatus httpStatus;

        try {
            validation.validationTransactionRules(transaction);
            httpStatus = HttpStatus.CREATED;
        } catch (Exception e) {
            httpStatus = HttpStatus.UNPROCESSABLE_ENTITY;
        }

        return ResponseEntity.status(httpStatus).build();
    }
}
