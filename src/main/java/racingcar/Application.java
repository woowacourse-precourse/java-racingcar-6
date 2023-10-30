package racingcar;


import controller.RacingcarController;
import view.RacingcarView;

public class Application {
    public static void main(String[] args) {
        RacingcarController rc = new RacingcarController();
        rc.run();
    }
}
