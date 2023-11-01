package racingcar.io;

import camp.nextstep.edu.missionutils.Console;
import racingcar.model.Cars;

public class Input {
    public static String CAR_INPUT_MSG = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    public static String ROUND_INPUT_MSG = "시도할 회수는 몇회인가요?";

    public Cars readCars() {
        System.out.println(CAR_INPUT_MSG);
        String userInput = Console.readLine();
        String[] carNames = userInput.split(",");
        return Cars.generateCars(carNames);
    }

    public Integer readRounds() {
        System.out.println(ROUND_INPUT_MSG);
        String userInput = Console.readLine();
        int rounds = Integer.parseInt(userInput);
        return rounds;
    }
}
