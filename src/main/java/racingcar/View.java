package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class View {
    private final String PLEASE_INPUT_CARS = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private final String PLEASE_INPUT_ROUND = "시도할 회수는 몇회인가요?";
    private final String RESULT_PREFIX = "\n실행결과";
    private final String WINNER_PREFIX= "최종 우승자 : ";

    public String getInput() {
        return Console.readLine();
    }

    public void showInputCars() {
        System.out.println(PLEASE_INPUT_CARS);
    }

    public void showInputRound() {
        System.out.println(PLEASE_INPUT_ROUND);
    }

    public void showResult(String result) {
        System.out.println(RESULT_PREFIX + result);
    }

    public void showWinner(String winner) {
        System.out.println(WINNER_PREFIX + winner);
    }
}
