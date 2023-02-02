import java.util.*;

public abstract class Subject {
  
      private ArrayList<Observer> observers = new ArrayList<>();
  
      public void registerObserver(Observer o) {
          observers.add(o);
      }
  
      public void removeObserver(Observer o) {
          observers.remove(o);
      }
  
      public abstract void notifyObservers();

      public ArrayList<Observer> observers() {
        return observers;
      }
  }
