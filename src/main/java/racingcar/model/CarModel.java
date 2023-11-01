package racingcar.model;

public interface CarModel extends Observable {
    int getDistance();

    String getName();
    
    void moveForward();
}
