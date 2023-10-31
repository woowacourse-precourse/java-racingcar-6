package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {

    private final String racingCar;
    private String progress = "";

    public Car(String racingCar) {
        this.racingCar = racingCar;
    }

    public String getRacingCar() {
        return racingCar;
    }

    public String getProgress() {
        return progress;
    }

    public void setProgress(String progress) {
        this.progress = progress;
    }
}
