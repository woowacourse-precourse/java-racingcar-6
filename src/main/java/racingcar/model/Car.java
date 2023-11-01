package racingcar.model;

import racingcar.enums.OutputMessage;

public class Car {
    private Name name;
    private ForwardCount forwardCount;

    public Car(String name) {
        this.name = new Name(name);
        this.forwardCount = new ForwardCount();
    }

    public Boolean move(Integer randomValue) {
        if (randomValue >= 4) {
            forwardCount.increaseCount();
            return true;
        }

        return false;
    }

    public String getForwardResultMessage() {
        String forwardResultNameFormat = OutputMessage.FORMAT_OF_NAME_AFTER_CAR_FORWARD.getMessage();
        String forwardResultProgressFormat = OutputMessage.FORMAT_OF_PROGRESS_AFTER_CAR_FORWARD.getMessage();

        String message = "";
        message += String.format(forwardResultNameFormat, this.name); // "%s : "
        message += String.format(forwardResultProgressFormat, this.forwardCount); // "%s"

        return message;
    }

    @Override
    public String toString() {
        String nameFormat = OutputMessage.FORMAT_OF_NAME.getMessage();

        return String.format(nameFormat, this.name); // "%s"
    }
}
