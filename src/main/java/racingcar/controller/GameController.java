package racingcar.controller;

import racingcar.domain.Car;

import java.util.ArrayList;
import java.util.List;

public class GameController {

    private List<List<Integer>>  gameResult;

    public void playGame(List<String> cars, List<Integer> processResult, int attemptCount, int carCount) {
        // [[o,x,x],[x,o,o],[x,x,x]]
        // [[1,0,0], [2,1,1], [3,2,1]] attemptCount개 * carCount개,
        gameResult = new ArrayList<>();

        // gameResult 0으로 초기화
        for (int i = 0; i < attemptCount; i++) {
            List<Integer> singleResult = new ArrayList<>();
            for (int j = 0; j < carCount; j++) {
                singleResult.add(0);
            }
            gameResult.add(singleResult);
        }

        for (int i=0; i<attemptCount; i++) {
            List<Integer> singleResult = new ArrayList<>();
            for (int j=0; j<carCount; j++) {
                Car car = new Car();
                int current = gameResult.get(i).get(j);
                if(car.isForward()) {
                    //////>?
                }
                //singleResult.add(res);
            }
            gameResult.add(singleResult);
        }
    }
}
