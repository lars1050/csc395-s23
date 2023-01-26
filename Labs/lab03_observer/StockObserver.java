public interface StockObserver {

    /* Receiving an update from the subject. */
    void update(Double dow, Double snp, Double mmm, Double msft);
  }