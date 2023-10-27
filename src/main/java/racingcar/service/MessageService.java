package racingcar.service;

import racingcar.domain.Cars;

public class MessageService {

    private static final String START_GAME = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String ASK_ATTEMPT = "시도할 회수는 몇회인가요?";
    private static final String GAME_RESULT = "\n실행 결과";
    private static final String FINAL_WINNER = "최종 우승자 : ";

    public void printStartGame() {
        println(START_GAME);
    }

    public void printAskAttempt() {
        println(ASK_ATTEMPT);
    }

    public void printGameResult() {
        println(GAME_RESULT);
    }

    public void printFinalWinner() {
        print(FINAL_WINNER);
    }

    public void printRank(Cars cars) {
        for (String carInfo : cars.getCurrentState()) {
            println(carInfo);
        }
        print("\n");
    }

    private void print(String message) {
        System.out.print(message);
    }

    private void println(String message) {
        System.out.println(message);
    }
}
