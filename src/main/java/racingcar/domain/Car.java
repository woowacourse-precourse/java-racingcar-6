package racingcar.domain;

/**
 * dto 분리
 */
public class Car {
    private Integer carId;
    private String carName;
    private Integer position;

    public Car(Integer number, String name) {
        this.carId = number;
        this.carName = name;
        this.position = 0;
    }

    public Car(Integer carId, String carName, Integer position) {
        this.carId = carId;
        this.carName = carName;
        this.position = position;
    }

    public Integer id() {
        return carId;
    }

    public String name() {
        return carName;
    }

    public Integer position() {
        return position;
    }
}
