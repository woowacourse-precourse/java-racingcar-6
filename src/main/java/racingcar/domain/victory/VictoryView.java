package racingcar.domain.victory;

import java.util.List;
import java.util.stream.IntStream;
import racingcar.domain.car.Car;

public class VictoryView {
    private final StringBuilder result = new StringBuilder("최종 우승자 : ");

    public void showVictory(List<Car> victoryCars) {
        appendCarNames(victoryCars);
        printVictoryCars();
    }
    private void printVictoryCars() {
        System.out.print(result);
    }

    private void appendCarNames(List<Car> victoryCars) {
        IntStream.range(0, victoryCars.size())
                .forEach(i -> {
                    victoryCars.get(i).appendCarName(result);
                    addRest(i, victoryCars.size());
                });
    }

    private void addRest(int index, int size) {
        if(isNotLast(index, size - 1)) {
            result.append(", ");
        }
    }

    private boolean isNotLast(int index, int lastIndex) {
        return index != lastIndex;
    }
}
