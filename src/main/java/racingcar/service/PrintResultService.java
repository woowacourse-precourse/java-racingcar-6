package racingcar.service;

import racingcar.entity.RacingCarEntity;

import java.util.ArrayList;
import java.util.List;

public class PrintResultService {

    public void printGameResult(List<RacingCarEntity> cars) {
        List<String> winners = getWinners(cars);
        System.out.println("최종 우승자 : " + winners.toString().replace("[","").replace("]",""));
    }

    public List<String> getWinners(List<RacingCarEntity> cars) {
        List<String> winners = new ArrayList<>();
        Integer maxMoveCount =  getMaxMoveCount(cars);
        for (RacingCarEntity car : cars) {
            if (car.getMoveCount() == maxMoveCount) winners.add(car.getName());
        }
        return winners;
    }

    public Integer getMaxMoveCount(List<RacingCarEntity> cars) {
        Integer maxMoveCount = 0;
        for (RacingCarEntity car: cars) {
            if (car.getMoveCount() > maxMoveCount){
                maxMoveCount = car.getMoveCount();
            }
        }
        return maxMoveCount;
    }

}
