package racingcar;

public class Application {
    public static void main(String[] args) {
        RacingCarController racingCarController = new RacingCarController(new RacingCarView());
        racingCarController.play();
    }
}
