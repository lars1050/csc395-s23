public interface WeatherObserver {

  /* Receiving an update from the subject. */
  void update(Integer temp, Integer precip, Integer air);
}
