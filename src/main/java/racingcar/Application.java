package racingcar;
import controller.RacingCarController;
public class Application {
    public static void main(String[] args) {
        RacingCarController controller = new RacingCarController();
        controller.addCarName();
        controller.startCarRace();
        controller.resultCarRace();

    }

}
