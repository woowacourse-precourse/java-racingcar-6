package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println(START_INPUT_MESSAGE);
        String racingCar = Console.readLine();

        System.out.println(INPUT_TRY_NUMBER);
        String gameNumber = Console.readLine();
    }

    private static final String START_INPUT_MESSAGE = "경주할 자동차 이름을 입력하세요. (이름은 쉼표(,) 기준으로 구분)";
    private static final String INPUT_TRY_NUMBER = "시도할 횟수는 몇회인가요?";


}
