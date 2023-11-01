package racingcar.service;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.domain.Car;
import racingcar.domain.Racing;
import racingcar.domain.RacingCarConst;
import racingcar.util.GlobalExceptionHandler;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static java.util.Collections.max;

public class RacingCarService implements RacingCarConst {

    private final static GlobalExceptionHandler globalExceptionHandler = new GlobalExceptionHandler();

    private static List<String> getCarsNameList(String cars) {
        List<String> carArray = new ArrayList<>();
        if (globalExceptionHandler.isValidCarArray(cars)) {
            carArray = List.of(cars.split(","));
        }
        return carArray;
    }

    public List<Car> getRacingCarsList(String cars) {
        List<String> racingCars = getCarsNameList(cars);
        final List<Car> carList = new ArrayList<>();

        for (int i=0; i<racingCars.size(); i++){
            if (globalExceptionHandler.isValidCarName(racingCars.get(i))) {
                final Car car = new Car(racingCars.get(i));
                carList.add(car);
            }
        }
        return carList;
    }

    public Racing startRace(String racingCount, List<Car> racingCarList) {
        if (globalExceptionHandler.isValidRacingCount(racingCount)) {
            final Racing racingGame = new Racing(racingCarList, Integer.parseInt(racingCount));
            return racingGame;
        }
        return null;
    }

    private int getRandomNumber() {
        return Randoms.pickNumberInRange(0, 9);
    }

    private boolean goFront() {
        int randomNumber = getRandomNumber();
        if (randomNumber>=AHEAD_LIMIT) {
            return true;
        }
        return false;
    }

    public void countAhead(Racing racingGame){
        for (Car car:racingGame.getRacingCarList()){
            if (goFront()) {
                car.updateAheadCount();
            }
        }
    }

    public void startRacingRound(Racing racingGame){
        countAhead(racingGame);
    }

    public HashMap<String, Integer> getAheadCountList(Racing racingGame) {
        final HashMap<String, Integer> aheadCountList = new HashMap<>();

        for (Car car:racingGame.getRacingCarList()){
            aheadCountList.put(car.getName(), car.getAheadCount());
        }
        return aheadCountList;
    }

    public void updateWinnerList(Racing racingGame) {
        final HashMap<String, Integer> aheadCountList = getAheadCountList(racingGame);

        aheadCountList.forEach((key, value) -> {
            if (value == max(aheadCountList.values())) {
                racingGame.updateWinnerList(key);
            }
        });
    }

}
