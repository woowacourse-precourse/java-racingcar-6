package racingcar.domain.victory;

import java.util.List;
import java.util.stream.IntStream;
import racingcar.domain.car.Car;

public class VictoryView {

    public void showVictory(List<Car> victoryCars) {
        System.out.print("최종 우승자 : ");
        printVictoryCars(victoryCars);
    }
    private void printVictoryCars(List<Car> victoryCars) {
        IntStream.range(0, victoryCars.size())
                .forEach(i -> {
                    victoryCars.get(i).showName();
                    addRest(victoryCars, i);
                });
    }

    private void addRest(List<Car> victoryCars, int i) {
        if(isNotLast(i, victoryCars.size()-1)) {
            printRest();
        }
    }

    private void printRest() {
        System.out.print(", ");
    }

    private boolean isNotLast(int index, int last) {
        return index != last;
    }
}
