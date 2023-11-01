package racingcar.model;

public interface Observable {
    void registerObserver(final Observer observer);

    void removeObserver(final Observer observer);

    void notifyObservers();
}
