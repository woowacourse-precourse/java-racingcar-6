package racingcar.view;

import java.util.List;
import racingcar.domain.Car;
import racingcar.domain.repository.CarRepository;

public class OutputView {
    private final static String SYMBOL_MOVE = "-";
    private final static String DIGIT_SCOPE_WITH_BLANK = " : ";
    private final static String DIGIT_COMMA_WITH_BLANK = ", ";

    public void outputWinner(List<String> names) {
        System.out.print("최종 우승자 : ");
        String result = String.join(DIGIT_COMMA_WITH_BLANK, names);
        System.out.println(result);
    }

    public void outputMovingRecord() {
        for (Car car : CarRepository.cars()) {
            outputCarNameWithScope(car);
            outputMovingSymbol(car.getMoveCount());
        }
    }

    private void outputMovingSymbol(int count) {
        for (int i = 0; i < count; i++) {
            System.out.print(SYMBOL_MOVE);
        }
        System.out.println();
    }

    private void outputCarNameWithScope(Car car) {
        System.out.print(car.getName() + DIGIT_SCOPE_WITH_BLANK);
    }
}
