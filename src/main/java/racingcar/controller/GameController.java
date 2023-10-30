package racingcar.controller;

import camp.nextstep.edu.missionutils.Console;
import racingcar.dto.UserInput;
import racingcar.service.GameService;
import racingcar.service.InputService;

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

        gameService.processGame(userInput);
    }

    private UserInput readValue() {
        String[] carNameArr = readCarNameArr();
        int frequency = readFrequency();

        return new UserInput(carNameArr, frequency);
    }

    private String[] readCarNameArr() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String[] carNameArr = Console.readLine().split(",");

        for(String carName : carNameArr) {
            inputService.checkCarNameValidation(carName);
        }

        return carNameArr;
    }

    private int readFrequency() {
        System.out.println("시도할 회수는 몇회인가요?");
        String frequency = Console.readLine();
        System.out.println();

        inputService.checkCompetitionNumberValidation(frequency);

        return Integer.parseInt(frequency);
    }

}
