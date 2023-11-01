package racingcar.view;

import static racingcar.view.ConstantMessage.NEXT_LINE;
import static racingcar.view.ConstantMessage.RESULT_MESSAGE_START;
import static racingcar.view.ConstantMessage.WINNER_IS;

import java.util.List;
import racingcar.model.Car;

public class OutputView implements View {
    private final StringBuilder result;

    OutputView() {
        result = new StringBuilder();
        result.append(RESULT_MESSAGE_START.message());
    }

    /**
     * 자동차들의 현재 상태를 출력할 문자열로 기록하는 메서드.
     *
     * @param cars 자동차(Car) 리스트
     */
    public void recordStatus(final List<Car> cars) {
        cars.forEach(car -> result.append(car.toString()).append(NEXT_LINE.message()));
        result.append(NEXT_LINE.message());
    }

    /**
     * 우승자들의 이름을 출력할 문자열로 기록하는 메서드.
     *
     * @param winners 우승자들의 이름 문자열 리스트
     */
    public void recordWinner(final List<String> winners) {
        result.append(WINNER_IS.message());
        String stringWithBracket = winners.toString();
        int rightOfLeftBracket = 1, leftOfRightBracket = stringWithBracket.length() - 1;
        result.append(winners.toString(), rightOfLeftBracket, leftOfRightBracket);
    }

    /**
     * 기록된 문자열을 출력하는 메서드.
     */
    public void printResult() {
        System.out.println(result);
    }
}