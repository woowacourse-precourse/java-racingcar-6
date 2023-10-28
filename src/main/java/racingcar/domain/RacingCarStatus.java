package racingcar.domain;

public class RacingCarStatus {

    private final String carName;
    private int position = 0;

    public RacingCarStatus(String carName) {
        this.carName = carName;
    }

    public void forWard() {
        this.position++;
    }
}
