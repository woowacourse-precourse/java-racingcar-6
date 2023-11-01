package racingcar.domain;


import racingcar.utils.NumberGenerator;

public class Car {

    private final String carName;
    private int position = 0;
    private final NumberGenerator numberGenerator;

    public Car(String carName, NumberGenerator numberGenerator) {
        this.carName = carName;
        this.numberGenerator = numberGenerator;
    }
}