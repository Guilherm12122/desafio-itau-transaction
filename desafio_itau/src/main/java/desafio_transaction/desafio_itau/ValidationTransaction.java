package desafio_transaction.desafio_itau;

import java.time.OffsetDateTime;
import java.util.Date;

public class ValidationTransaction {

    public void validationTransactionRules(Transaction transaction) throws Exception {

        boolean result_validation = (validateTimeTransaction(transaction) &&
                                     validateValueTransaction(transaction) &&
                                     validateNotNullFields(transaction));

        if (!result_validation) {
            throw new Exception("Transação inválida.");
        }

    }

    public boolean validateValueTransaction(Transaction transaction){
        return transaction.getValor() >= 0.00;
    }

    public boolean validateTimeTransaction(Transaction transaction){

        Date date_now = new Date();

        Date date_transaction = Date.from(OffsetDateTime.parse(
                transaction.getDataHora()).toInstant());

        return date_transaction.equals(date_now) || date_transaction.before(date_now);
    }

    public boolean validateNotNullFields(Transaction transaction){
        return !transaction.getDataHora().isEmpty() && !transaction.getValor().isNaN();
    }
}
