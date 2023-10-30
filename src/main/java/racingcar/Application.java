package racingcar;

public class Application {
    public static void main(String[] args) {
        RacingCarGameFactory racingCarGameFactory = new RacingCarGameFactoryImpl();
        RacingCarGameController racingCarGameController = racingCarGameFactory.racingCarController();
        racingCarGameController.play();
    }
}
