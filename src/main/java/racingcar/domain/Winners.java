package racingcar.domain;

import static racingcar.global.constants.MessageType.FINAL_RESULT_MESSAGE;
import static racingcar.global.constants.SymbolType.FINAL_RESULT_TOKEN;

import java.util.List;

public class Winners {
    private List<Car> winners;

    private Winners(Cars cars) {
        this.winners = findWinners(cars);
    }

    public static Winners of(Cars cars) {
        return new Winners(cars);
    }

    @Override
    public String toString() {
        List<String> names = convertCarListToNames(winners);
        String winners = String.join(FINAL_RESULT_TOKEN.getSymbol(), names);
        return String.format(FINAL_RESULT_MESSAGE.getMessage(), winners);
    }
    
    private List<Car> findWinners(Cars cars) {
        return cars.findMaxPositionCars();
    }

    private List<String> convertCarListToNames(List<Car> winners) {
        return winners.stream().map(Car::getName).toList();
    }
}
