package racingcar;

import racingcar.object.Host;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Host host = new Host();
        host.inputCars();
        host.inputAttemptCount();
        host.carRacingResults();

    }
}
