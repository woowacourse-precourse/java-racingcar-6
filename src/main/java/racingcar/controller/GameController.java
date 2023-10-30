package racingcar.controller;

import camp.nextstep.edu.missionutils.Console;
import racingcar.dto.UserInput;

// 사용자로부터 값을 입력받고 결과를 출력하기 위한 클래스
public class GameController {
    public void startGame() {
        UserInput userInput = readValue();

        // implement Logic
    }

    private UserInput readValue() {
        String[] carNameArr = readCarNameArr();
        int frequency = readFrequency();

        return new UserInput(carNameArr, frequency);
    }

    private String[] readCarNameArr() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String[] carNameArr = Console.readLine().split(",");

        // checkValidation

        return carNameArr;
    }

    private int readFrequency() {
        System.out.println("시도할 회수는 몇회인가요?");
        String frequency = Console.readLine();
        System.out.println();

        // checkValidation

        return Integer.parseInt(frequency);
    }

}
