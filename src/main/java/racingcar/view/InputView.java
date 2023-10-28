package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class InputView {

    private static final String INPUT_CAR_NAMES_MESSAGE = "경주할 자동차 이름을 입력하세요. (이름은 쉼표(,) 기준으로 구분)";
    private static final String INPUT_COUNT_MESSAGE = "시도할 회수는 몇회인가요?";
    private static final String FINAL_WINNER = "최종 우승자 : ";

    public String getCarNames() {
        print(INPUT_CAR_NAMES_MESSAGE);
        return readLine();
    }

    public int getTryNumber() {
        print(INPUT_COUNT_MESSAGE);
        return Integer.parseInt(readLine());
    }

    public void printWinner(String winners) {
        print(FINAL_WINNER + winners);
    }

    public void close() {
        Console.close();
    }

    public void print(String message) {
        System.out.println(message);
    }


    public void println() {
        System.out.println();
    }
}
