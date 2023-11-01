package racingcar;

import java.util.List;

public class OutputView {

    public static final String START_GAME = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    public static final String ASK_NUMBER_OF_RACE = "시도할 회수는 몇회인가요?";
    public static final String SHOW_RESULT_OF_EACH_RACE = "\n실행 결과";
    public static final String SHOW_WINNER = "최종 우승자 : ";

    public static void startGame() {
        System.out.println(START_GAME);
    }

    public static void askNumberOfRace() {
        System.out.println(ASK_NUMBER_OF_RACE);
    }

    public static void showStatusOfCar(List<Car> carList) {
        System.out.println(carList);
    }

    public static void showResultOfEachRaceText() {
        System.out.println(SHOW_RESULT_OF_EACH_RACE);
    }

    public static void showWinnerText() {
        System.out.print(SHOW_WINNER);
    }

    public static void showWinner(StringBuilder sb) {
        System.out.println(sb);
    }
}
