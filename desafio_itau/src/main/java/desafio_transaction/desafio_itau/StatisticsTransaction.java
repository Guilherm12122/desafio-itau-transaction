package desafio_transaction.desafio_itau;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class StatisticsTransaction {

    private List<Transaction> transactions = new ArrayList<>();
    private Integer count;
    private Double sum;
    private Double avg;
    private Double min;
    private Double max;

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
        return getSum() / getCount();
    }

    public Double getMin() {
        return this.transactions.stream()
                .map(Transaction::getValor)
                .min(Double::compareTo).orElse(null);
    }

    public Double getMax() {
        return this.transactions.stream()
                .map(Transaction::getValor)
                .max(Double::compareTo).orElse(null);
    }

}