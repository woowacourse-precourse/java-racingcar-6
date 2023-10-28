package racingcar.domain;

import static racingcar.global.GameConfig.MOVE_DIST;
import static racingcar.global.GameConfig.RANDOM_NUMBER_END_INCLUSIVE;
import static racingcar.global.GameConfig.RANDOM_NUMBER_START_INCLUSIVE;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

public class CarManager {
    private final List<Car> cars;
    private List<LinkedHashMap<String, Integer>> attempts;

    public CarManager(List<Car> cars) {
        this.cars = cars;
        attempts=new ArrayList<>();
    }

    public List<LinkedHashMap<String, Integer>> getAttempts() {
        return attempts;
    }

    public void attempt(){
        LinkedHashMap<String, Integer> record=new LinkedHashMap<>();

        for (Car car : cars) {
            if(isMove())
                car.move(MOVE_DIST);

            record.put(car.getName(), car.getTotalDistance());
        }

       attempts.add(record);
    }

    public List<Car> getWinners(){
        List<Car> winners=new ArrayList<>();

        int maxTotalDistance = cars.get(0).getTotalDistance();
        for (Car car : cars) {
            int totalDistance=car.getTotalDistance();

            if(totalDistance<maxTotalDistance) continue;

            if(totalDistance==maxTotalDistance){
                winners.add(car);
                continue;
            }

            winners.clear();
            maxTotalDistance=totalDistance;
            winners.add(car);
        }

        return winners;
    }

    private boolean isMove(){
        int randomNumber = Randoms.pickNumberInRange(RANDOM_NUMBER_START_INCLUSIVE, RANDOM_NUMBER_END_INCLUSIVE);
        return randomNumber>=4;
    }
}
