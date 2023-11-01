package racingcar.controller;

import static java.util.Collections.max;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import racingcar.model.Car;
import racingcar.model.Racing;
public class RacingStartController {
    private final static ExceptionUtils e = new ExceptionUtils();
    public static List<String> getCarsNameList(String cars) {
        List<String> carArray = new ArrayList<>();
        if (e.checkExistComma(cars)) {
            carArray = List.of(cars.split(","));
        }
        return carArray;
    }

    public List<Car> getRacingCarList(String cars) {
        List<String> racingCars = getCarsNameList(cars);
        List<Car> carList = new ArrayList<>();

        for (int i=0; i<racingCars.size(); i++){
            if (e.checkLength(racingCars.get(i))) {
                final Car car = new Car(racingCars.get(i));
                carList.add(car);
            }
        }
        return carList;
    }

    public Racing run(String racingCount, List<Car> racingCarList) {
        Racing racingGame = null;
        if (e.checkCountString(racingCount)) {
            racingGame = new Racing(racingCarList, Integer.parseInt(racingCount));
        }
        return racingGame;
    }

    private boolean checkForward() {
        int randNum = Randoms.pickNumberInRange(0, 9);
        if (randNum >= 4) {
            return true;
        }
        return false;
    }

    public void startMove(Racing racing) {
        for (Car car : racing.getCarList()) {
            if (checkForward()) {
                car.move();
            }
        }
    }
    public HashMap<String, Integer> getFowardCountList(Racing racing) {
        HashMap<String, Integer> fowardCountList = new HashMap<>();

        for (Car car:racing.getCarList()){
            fowardCountList.put(car.getName(), car.getPoisiton());
        }
        return fowardCountList;
    }
    public void resultWinnerList(Racing racing) {
        HashMap<String, Integer> fowardCountList = getFowardCountList(racing);

        fowardCountList.forEach((key, value) -> {
            if (value == max(fowardCountList.values())) {
                racing.addWinnerList(key);
            }
        });
    }
}
