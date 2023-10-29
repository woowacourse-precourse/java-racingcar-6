package racingcar.domain.victory;

import java.util.List;
import java.util.stream.IntStream;
import racingcar.domain.car.Car;

public class VictoryView {

    public void showVictory(List<Car> victoryCars) {
        printVictoryCars(victoryCars);
    }
    private void printVictoryCars(List<Car> victoryCars) {
        StringBuilder result = new StringBuilder("최종 우승자 : ");
        appendCarNames(victoryCars, result);
        System.out.print(result);
    }

    private void appendCarNames(List<Car> victoryCars, StringBuilder result) {
        IntStream.range(0, victoryCars.size())
                .forEach(i -> {
                    victoryCars.get(i).appendCarName(result);
                    addRest(victoryCars, i, result);
                });
    }

    private void addRest(List<Car> victoryCars, int i, StringBuilder result) {
        if(isNotLast(i, victoryCars.size()-1)) {
            result.append(", ");
        }
    }

    private boolean isNotLast(int index, int last) {
        return index != last;
    }
}
