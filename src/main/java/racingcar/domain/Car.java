package racingcar.domain;

import racingcar.constant.ErrorMessage;

public class Car {
    private String name;
    private int position;

    public Car(String name) {
        if(name.isEmpty()) {
            throw new IllegalArgumentException(ErrorMessage.CAR_NAME_NULL_MESSAGE.getMessage());
        }

        if (name.length() > 5) {
            throw new IllegalArgumentException(ErrorMessage.CAR_NAME_SIZE_ERROR.getMessage());
        }

        this.name = name;
        this.position = 0;
    }

    public String getName() {
        return this.name;
    }

    public int getPosition() {
        return this.position;
    }

    public void forward() {
        ++this.position;
    }
}
