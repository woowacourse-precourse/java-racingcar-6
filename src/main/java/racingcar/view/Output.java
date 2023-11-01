package racingcar.view;

import java.util.List;
import racingcar.model.Car;

public class Output {
    public static final String START_SENTENCE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    public static final String RANDOM_QUESTION_SENTENCE = "시도할 회수는 몇회인가요?";
    public static final String WINNER_SENTENCE = "최종 우승자 :";
    public static final String NAME_DIVISION_WORD = ",";
    public static final String TITLE_DIVISION_WORD = " : ";
    public static final String CAR_PROGRESS_WORD = "-";
    public static final String BLANK_WORD = " ";

    public static void printInputCarName() {
        System.out.println(START_SENTENCE);
    }

    public static void printInputRandomNumber() {
        System.out.println(RANDOM_QUESTION_SENTENCE);
    }

    public static void printScore(List<Car> cars) {
        for (Car car : cars) {
            printScoreOfCars(car);
        }
        System.out.println();
    }

    private static void printScoreOfCars(Car car) {
        System.out.print(car.getName() + TITLE_DIVISION_WORD);
        printPosition(car);
        System.out.println();
    }

    private static void printPosition(Car car) {
        for (int i = 0; i < car.getPosition(); i++) {
            System.out.print(CAR_PROGRESS_WORD);
        }
    }

    public static void printWinner(List<String> carNames) {
        StringBuilder winnerStringBuilder = new StringBuilder();
        winnerStringBuilder.append(WINNER_SENTENCE);

        for (String winner : carNames) {
            winnerStringBuilder.append(BLANK_WORD).append(winner).append(NAME_DIVISION_WORD);
        }

        winnerStringBuilder.setLength(winnerStringBuilder.length() - 1);
        System.out.println(winnerStringBuilder);
    }

}
