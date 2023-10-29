package racingcar.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
 *   게임 등수의 정보를 담당
 * */
public class GameRank {
    private static final int INITIALIZE_RECORD = 0;
    private List<Car> gameRank;


    public GameRank(List<Car> gameResult) {
        Collections.sort(gameResult);
        gameRank = gameResult;
    }

    //createGameWinnerCars 가 더 가독성이 좋은가
    public GameWinner createGameWinner() {
        return new GameWinner(findWinner());
    }

    private List<Car> findWinner() {
        List<Car> cars = new ArrayList<>();
        int maxRecord = getMaxRecord();
        for (Car car : gameRank) {
            addWinner(cars, car, maxRecord);
            if (!car.isEqualRecord(maxRecord)) {
                break;
            }
        }
        return cars;
    }

    public int getMaxRecord() {
        int maxRecord = INITIALIZE_RECORD;
        for (Car car : gameRank) {
            maxRecord = car.getBiggerRecord(maxRecord);
        }
        return maxRecord;
    }

    private void addWinner(List<Car> cars, Car car, int maxRecord) {
        if (car.isEqualRecord(maxRecord)) {
            cars.add(car);
        }
    }

//
//    public int getMaxRecord() {
//        int maxRecord = 0;
//        for (Car car : gameRank) {
//            car.getBiggerRecord
//        }
//    }

    //commit하면서 문맥상 이상, 변수명 이상, 흐름 이상 확인해서 리팩토링 후에 테스트
}
