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

    public void showResult() {
        int maxProcess = findMaxProcess();
        List<String> maxProgressCarName = findMaxProgressCarName(maxProcess);
        String result = String.join(", ", maxProgressCarName);
        OutputUtil.printWithLine("최종 우승자 : " + result);
    }

    private int findMaxProcess() {
        List<RacingCar> cars = getCars();
        int max = -1;
        for (int i = 0; i < cars.size(); i++) {
            RacingCar racingCar = cars.get(i);
            int progress = racingCar.getProgress();
            max = Math.max(max, progress);
        }

        return max;
    }

    private List<String> findMaxProgressCarName(int maxProgress) {
        List<RacingCar> cars = getCars();
        List<String> result = new ArrayList<>();
        for (int i = 0; i < cars.size(); i++) {
            addMaxCarName(maxProgress, cars, result, i);
        }

        return result;
    }

    private static void addMaxCarName(int maxProgress, List<RacingCar> cars, List<String> result, int i) {
        RacingCar racingCar = cars.get(i);
        int progress = racingCar.getProgress();
        if (progress == maxProgress) {
            result.add(racingCar.getName());
        }
    }

}
