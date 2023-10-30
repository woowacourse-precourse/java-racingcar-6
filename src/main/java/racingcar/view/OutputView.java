package racingcar.view;


import java.util.ArrayList;
import java.util.List;
import racingcar.model.Car;

public class OutputView {

    public static final String CAR_NAME_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    public static final String REPEAT_NUMBER_MESSAGE = "시도할 회수는 몇회인가요?";
    public static final String RESULT_MESSAGE = "\n실행 결과";
    public static final String WINNER_MESSAGE = "최종 우승자 : ";

    public static void printCarName() {
        System.out.println(CAR_NAME_MESSAGE);
    }

    public static void printRepeatNumber() {
        System.out.println(REPEAT_NUMBER_MESSAGE);
    }

    public static void printResult() {
        System.out.println(RESULT_MESSAGE);
    }

    public static void printRacing(String carName, int location) {
        StringBuilder result = new StringBuilder();

        result.append(carName).append(" : ");
        result.append("-".repeat(Math.max(0, location)));
        System.out.println(result);
    }


    public static void printWinner(List<Car> winnerCars) {
        StringBuilder stringBuilder = new StringBuilder();
        List<String> winners = new ArrayList<>();

        for (Car car : winnerCars) {
            winners.add(car.getName());
        }
        stringBuilder.append(WINNER_MESSAGE).append(String.join(", ", winners));
        System.out.println(stringBuilder);
    }
}
