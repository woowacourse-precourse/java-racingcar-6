package racingcar.controller;

import camp.nextstep.edu.missionutils.Console;
import racingcar.dto.UserInput;
import racingcar.service.GameService;
import racingcar.service.InputService;

import static racingcar.util.GameDefaultMessage.*;

// 사용자로부터 값을 입력받고 결과를 출력하기 위한 클래스
public class GameController {
    private final InputService inputService;
    private final GameService gameService;

    public GameController(InputService inputService, GameService gameService) {
        this.inputService = inputService;
        this.gameService = gameService;
    }

    public void startGame() {
        UserInput userInput = readValue();

        String gameResult = gameService.processGame(userInput);

        System.out.println(gameResult);
    }

    private UserInput readValue() {
        String[] carNameArr = readCarNameArr();
        int frequency = readFrequency();

        return new UserInput(carNameArr, frequency);
    }

    private String[] readCarNameArr() {
        System.out.println(MESSAGE_INPUT_CAR_NAME);
        String[] carNameArr = Console.readLine().split(",");

        for(String carName : carNameArr) {
            inputService.checkCarNameValidation(carName);
        }

        return carNameArr;
    }

    private int readFrequency() {
        System.out.println(MESSAGE_INPUT_FREQUENCY);
        String frequency = Console.readLine();
        System.out.println();

        inputService.checkFrequencyValidation(frequency);

        return Integer.parseInt(frequency);
    }

}
