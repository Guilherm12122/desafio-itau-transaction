package desafio_transaction.desafio_itau;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class StatisticsTransaction {

    private List<Transaction> transactions = new ArrayList<>();
    private Integer count = 0;
    private Double sum = 0.00;
    private Double avg = 0.00;
    private Double min = 0.00;
    private Double max = 0.00;

    public StatisticsTransaction(){}

    public StatisticsTransaction(List<Transaction> transactions){
        this.transactions = transactions;
        this.count = getCount();
        this.sum = getSum();
        this.avg = getAvg();
        this.min = getMin();
        this.max = getMax();
    }

    public Integer getCount(){
        return this.transactions.size();
    }

    public Double getSum(){
        return this.transactions.stream().map(Transaction::getValor)
                .reduce(0.00, Double::sum);
    }

    public Double getAvg(){
        double avg_tmp = getSum() / getCount();
        return Double.isNaN(avg_tmp) ? 0.0 : avg_tmp;
    }

    public Double getMin() {
        return this.transactions.stream()
                .map(Transaction::getValor)
                .min(Double::compareTo).orElse(0.00);
    }

    public Double getMax() {
        return this.transactions.stream()
                .map(Transaction::getValor)
                .max(Double::compareTo).orElse(0.00);
    }

}