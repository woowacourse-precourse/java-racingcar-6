package racingcar;

import racingcar.application.CarGameService;
import racingcar.domain.Referee;
import racingcar.infra.MoveCommandMakerImpl;
import racingcar.presentation.CarGameController;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        CarGameService carGameService = new CarGameService(new MoveCommandMakerImpl(), new Referee());
        CarGameController carGameController = new CarGameController(carGameService);
        try {
            carGameController.startGame();
        }
        catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
            throw e;
        }
    }
}
