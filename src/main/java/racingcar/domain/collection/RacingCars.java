package racingcar.domain.collection;

import racingcar.domain.RacingCar;
import racingcar.domain.interfaces.Cars;
import racingcar.util.OutputUtil;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RacingCars implements Cars {

    private final List<RacingCar> cars;

    public RacingCars(List<RacingCar> cars) {
        this.cars = cars;
    }

    public List<RacingCar> getCars() {
        return Collections.unmodifiableList(cars);
    }

    public String showResult() {
        int maxProcess = findMaxProgress();
        List<String> maxProgressCarName = findMaxProgressCarName(maxProcess);
        String result = String.join(", ", maxProgressCarName);
        OutputUtil.printWithLine("최종 우승자 : " + result);
        return result;
    }

    private int findMaxProgress() {
        List<RacingCar> cars = getCars();
        List<Integer> progressValues = new ArrayList<>();
        int max = -1;
        for (int i = 0; i < cars.size(); i++) {
            RacingCar racingCar = cars.get(i);
            racingCar.putProgressAt(progressValues);
        }
        return Collections.max(progressValues);
    }

    private List<String> findMaxProgressCarName(int maxProgress) {
        List<RacingCar> cars = getCars();
        List<String> result = new ArrayList<>();
        for (int i = 0; i < cars.size(); i++) {
            putMaxProgressCarNameAt(maxProgress, cars.get(i), result);
        }

        return result;
    }

    private void putMaxProgressCarNameAt(int maxProgress, RacingCar car, List<String> result) {
        if (car.isProgressEqualTo(maxProgress)) {
            result.add(car.getName());
        }
    }

}
