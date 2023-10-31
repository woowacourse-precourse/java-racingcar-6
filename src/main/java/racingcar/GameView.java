package racingcar;

import camp.nextstep.edu.missionutils.Console;
import racingcar.car.CarValidator;
import racingcar.round.RoundValidator;

public class GameView {

    private static GameView gameView = new GameView();

    private GameView() {
    }

    public static GameView getInstance() {
        return gameView;
    }

    //사용자에게 자동차 이름 입력 받기
    public String[] carsInput() {
        String userInput;
        String[] carNames;
        do {
            System.out.println(Constant.START_NAME_MESSAGE);
            userInput = Console.readLine();
            carNames = userInput.split(",");
        } while (!CarValidator.carValidation(carNames));

        return carNames;
    }

    //사용자에게 시도활 횟수 입력 받기
    public String roundInput() {
        String round;
        do {
            System.out.println(Constant.START_NUMBER_MESSAGE);
            round = Console.readLine();
        } while (!RoundValidator.roundValidation(round));

        return round;
    }
}
