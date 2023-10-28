package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;
import racingcar.controller.GameController;
import racingcar.model.Car;
import racingcar.model.Game;
import racingcar.validator.CarValidator;
import racingcar.validator.RacingCountValidator;
import racingcar.view.GameView;

public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        GameView.displayStartGame();
        String input = Console.readLine();

        // 1. 입력값이 숫자, 영문, 쉼표로만 구성되어있는지 확인한다
        CarValidator.validateNameUsingCommas(input);
        List<String> carNameList = List.of(input.split(","));

        // 2. 이름이 5글자 이하인지 확인해서 participantCars 에 포함시킨다
        List<Car> participantCars = new ArrayList<>();
        for (String carName : carNameList) {
            CarValidator.validateNameLength(carName);

            Car car = new Car(carName);
            participantCars.add(car);
        }

        GameView.displayAskTryCount();
        String tryCount = Console.readLine();
        int intTryCount = Integer.parseInt(tryCount);

        RacingCountValidator.validateRacingCount(tryCount);
        Game game = new Game(participantCars);
        GameController gameController = new GameController(intTryCount, game);
        gameController.playGame();
    }
}
