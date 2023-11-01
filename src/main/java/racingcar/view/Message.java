package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

public class Message {
    private static final String INPUT_CAR_NAMES = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String RESULT_MESSAGE = "실행 결과";
    private static final String NUMBER_OF_TRIES = "시도할 회수는 몇회인가요?";
    private static final String FINAL_WINNER = "최종 우승자 : ";

    public String inputCarNames() {
        System.out.println(INPUT_CAR_NAMES);
        return Console.readLine();
    }

    public String inputTryNumber() {
        System.out.println(NUMBER_OF_TRIES);
        return Console.readLine();
    }

    public void printFinalWinner(String winners) {
        System.out.print(FINAL_WINNER);
        System.out.print(winners);
    }

    public void printResultMessage() {
        System.out.println();
        System.out.println(RESULT_MESSAGE);
    }

    public void printSingleLine(String line) {
        System.out.println(line);
    }

    public void printLineBreak() {
        System.out.println();
    }
}
