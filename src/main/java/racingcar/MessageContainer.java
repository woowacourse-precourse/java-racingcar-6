package racingcar;

public class MessageContainer {
    public String showCarResult(Car car) {
        return car.getName() + " : " + "-".repeat(car.getPosition());
    }
}


