package racingcar.view;

import racingcar.model.Car;

public class OutputView {

    public static final String INPUT_CAR_NAMES_MESSAGE = "경주할 자동차 이름을 입력하세요. (이름은 쉼표(,) 기준으로 구분)";
    public static final String INPUT_ROUND_NUMBER_MESSAGE = "시도할 회수는 몇회인가요?";
    public static final String RACE_RESULT_MESSAGE = "실행 결과";
    public static final String WINNER_MESSAGE = "최종 우승자 : ";
    public static final String COLON = " : ";
    public static final String DASH = "-";

    public void printInputCarNames() {
        System.out.println(INPUT_CAR_NAMES_MESSAGE);
    }

    public void printInputRoundNumber() {
        System.out.println(INPUT_ROUND_NUMBER_MESSAGE);
    }

    public void printRaceResult() {
        System.out.println(RACE_RESULT_MESSAGE);
    }

    public void printProgress(Car car) {
        System.out.println(getProgress(car));
    }

    public void printLine() {
        System.out.println();
    }

    public void printWinner(String winnerName) {
        System.out.print(WINNER_MESSAGE);
        System.out.println(winnerName);
    }

    private String getProgress(Car car) {
        String progress = "";
        progress += car.getName();
        progress += COLON;
        progress += getDash(car.getProgress());
        return progress;
    }

    public String getDash(int number) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < number; i++) {
            sb.append(DASH);
        }
        return sb.toString();
    }
}
