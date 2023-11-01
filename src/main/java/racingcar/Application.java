package racingcar;

import racingcar.presentation.RacingController;
import racingcar.utils.IOHandler;

public class Application {
    public static void main(String[] args) {
        RacingController racingController = new RacingController();
        try {
            racingController.startGame();
        } finally {
            IOHandler.close();
        }
    }
}