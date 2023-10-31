package racingcar.vIew;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private static final String INPUT_CARS_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String INPUT_NUMBER_OF_GAMES_MESSAGE = "시도할 회수는 몇회인가요?";

    public String inputCars() {
        System.out.println(INPUT_CARS_MESSAGE);
        return Console.readLine();
    }

    public String inputNumberOfGame() {
        System.out.println(INPUT_NUMBER_OF_GAMES_MESSAGE);
        return Console.readLine();
    }
}
