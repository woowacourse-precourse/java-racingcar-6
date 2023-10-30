package racingcar;

import camp.nextstep.edu.missionutils.Console;
import racingcar.controller.RacingCarController;
import racingcar.model.service.RacingCarService;
import racingcar.model.service.RacingCarServiceImp;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        RacingCarController racingCarController = createRacingCarController();
        racingCarController.run();
        closeConsole();
    }

    private static RacingCarController createRacingCarController() {
        RacingCarService racingCarService = new RacingCarServiceImp();
        return new RacingCarController(racingCarService);
    }

    private static void closeConsole() {
        Console.close();
    }
}