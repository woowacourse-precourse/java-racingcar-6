package racingcar;

public interface Car {
    Car runAndReturnNewCar(Long randomNum);

    Long getPosition();

    String getCarName();

    String getCarStatus();
}