package racingcar.view;

import racingcar.domain.Cars;

public class OutputView {

    private static final String START_GAME = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String ASK_ATTEMPT = "시도할 회수는 몇회인가요?";
    private static final String GAME_RESULT = "실행 결과";
    private static final String FINAL_WINNER = "최종 우승자";
    private static final String PRINT_GAME_RESULT_FORMAT = "\n%s";
    private static final String PRINT_FINAL_WINNER_FORMAT = "%s : %s";
    private static final String BLANK_STRING = "";

    public void printStartGame() {
        println(START_GAME);
    }

    public void printAskAttempt() {
        println(ASK_ATTEMPT);
    }

    public void printGameResult() {
        println(String.format(PRINT_GAME_RESULT_FORMAT, GAME_RESULT));
    }

    public void printFinalWinner(final String winner) {
        print(String.format(PRINT_FINAL_WINNER_FORMAT, FINAL_WINNER, winner));
    }

    public void printRank(final Cars cars) {
        for (String carInfo : cars.receiveCurrentRank()) {
            println(carInfo);
        }
        println();
    }

    private void print(final String message) {
        System.out.print(message);
    }

    private void println(final String message) {
        System.out.println(message);
    }

    private void println() {
        println(BLANK_STRING);
    }
}
