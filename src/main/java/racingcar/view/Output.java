package racingcar.view;

import java.util.List;
import racingcar.domain.Car;

public class Output {

    public static final String NAME_INPUT_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    public static final String ROUND_NUMBER_INPUT_MESSAGE = "시도할 회수는 몇회인가요?";
    public static final String START_ROUND_MESSAGE = "\n실행 결과";
    public static final String SEPARATE_NAME_TO_SCORE = " : ";
    public static final String SCORE = "-";
    public static final String WINNER_MESSAGE_START = "최종 우승자 : ";
    public static final String WINNER_SEPARATER = ", ";


    public void printRoundResult(List<Car> cars) {
        cars.forEach(car -> {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(car.getCarName());
            stringBuilder.append(SEPARATE_NAME_TO_SCORE);
            for (int i = 0; i < car.getPosition(); i++) {
                stringBuilder.append(SCORE);
            }
            System.out.println(stringBuilder.toString());
        });
        System.out.println();
    }

    public void printGameResult(List<Car> winnerList) {
        List<String> winnerNames = winnerList.stream().map(Car::getCarName).toList();
        System.out.print(WINNER_MESSAGE_START);
        System.out.println(String.join(WINNER_SEPARATER, winnerNames));
    }

    public void printCarNamesInputMessage() {
        System.out.println(NAME_INPUT_MESSAGE);
    }

    public void printRoundNumberInputMessage() {
        System.out.println(ROUND_NUMBER_INPUT_MESSAGE);
    }

    public void printStartRoundMessage() {
        System.out.println(START_ROUND_MESSAGE);
    }
}
