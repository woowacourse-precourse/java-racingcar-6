package racingcar.domain;

import static racingcar.utils.ErrorMessage.*;

import static racingcar.utils.Message.ProgressBar;

public class Car {
    private final String name;
    private int progress;

    public Car(String name) {
        validateCarName(name);
        this.name = name;
        this.progress = 0;
    }

    public Car(String name, int progress) {
        validateCarName(name);
        this.name = name;
        this.progress = progress;
    }

    public void validateCarName(String name) {
        if(name.length() > 5){
            throw new IllegalArgumentException(INVALID_NAME_LENGTH.getMessage());
        }
    }

    public void moveForward() {
        this.progress++;
    }

    public String getName() {
        return name;
    }

    public int getProgress() {
        return progress;
    }

    public String printProgressBar() {
        String progressBar = ProgressBar.getMessage();
        return progressBar.repeat(this.progress);
    }

}
