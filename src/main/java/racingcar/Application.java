package racingcar;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        RacingCar racingCar = new RacingCar();
        RacingCarInput racingCarInput = new RacingCarInput();
        ValidInputChecker validInputChecker = new ValidInputChecker();
        RacingCarController racingCarController = new RacingCarController(racingCar, racingCarInput, validInputChecker);

        racingCarController.startRacing();
    }
}
