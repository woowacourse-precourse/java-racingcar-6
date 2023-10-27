package racingcar.service;

import racingcar.domain.Cars;

public class MessageService {

    private static final String START_GAME = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String ASK_ATTEMPT = "시도할 회수는 몇회인가요?";
    private static final String GAME_RESULT = "실행 결과";
    private static final String FINAL_WINNER = "최종 우승자";

    public void printStartGame() {
        println(START_GAME);
    }

    public void printAskAttempt() {
        println(ASK_ATTEMPT);
    }

    public void printGameResult() {
        String message = String.format("\n%s", GAME_RESULT);
        println(message);
    }

    public void printFinalWinner(String winner) {
        String message = String.format("%s : %s", FINAL_WINNER, winner);
        print(message);
    }

    public void printRank(Cars cars) {
        for (String carInfo : cars.getCurrentState()) {
            println(carInfo);
        }
        println();
    }

    private void print(String message) {
        System.out.print(message);
    }

    private void println(String message) {
        System.out.println(message);
    }

    private void println() {
        println("");
    }
}
