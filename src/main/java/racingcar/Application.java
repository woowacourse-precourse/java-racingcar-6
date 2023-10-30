package racingcar;

import com.sun.jdi.InvalidTypeException;
import service.CarMoveService;
import service.CarRacingWinnerService;
import service.UserInputCarMoveCountFactory;
import service.UserInputCarNameFactory;

public class Application {
    public static void main(String[] args) throws InvalidTypeException {
        // TODO: 프로그램 구현
        RacingCarGameController racingCarGameController = new RacingCarGameController();
        racingCarGameController.play();
    }
}
