package racingcar;

public class Application {
    public static void main(String[] args) {
        RacingCarGameController racingCarGameController = new RacingCarGameController();
        racingCarGameController.gameInit();
        racingCarGameController.runGame();
    }
}
