package racingcar.view;

import racingcar.domain.Car;
import racingcar.domain.repository.CarRepository;

public class OutputView {
    private final static String SYMBOL_MOVE = "-";

    public void outputResult() {
        for (Car car : CarRepository.cars()) {
            outputCarName(car);
            outputMovingSymbol(car.getMoveCount());
        }
    }

    private void outputMovingSymbol(int count) {
        for(int i = 0; i < count; i++) {
            System.out.print(SYMBOL_MOVE);
        }
        System.out.println();
    }

    private void outputCarName(Car car) {
        System.out.print(car.getName() + " : ");
    }
}
