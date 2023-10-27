package racingcar.domain;

import racingcar.domain.interfaces.Car;

public class RacingCar implements Car {

    private final String name;
    private final int progress;

    public RacingCar(String name, int progress) {
        this.name = name;
        this.progress = progress;
    }

    public String printInfo() {
        StringBuilder sb = new StringBuilder();
        sb.append(name).append(" : ");
        for (int i = 0; i < progress; i++) {
            sb.append("-");
        }
        return sb.toString();
    }


}
