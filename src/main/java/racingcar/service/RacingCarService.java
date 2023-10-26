package racingcar.service;

import java.util.HashMap;
import java.util.List;
import java.util.Random;
import racingcar.model.Cars;
import racingcar.util.ConverterUtil;
import racingcar.util.RandomNumUtil;

public class RacingCarService {
    private static final String FORWARD_MOVING = "-";
    private static Cars cars;
    private static HashMap<String, String> gameResult = new HashMap<>();

    public void createCars(String carNames) {
        List<String> carsList = ConverterUtil.covertStringToList(carNames);
        cars = new Cars(carsList);
        gameResult = cars.initCarsMap();
    }

    public boolean judgeMove() {
        int num = RandomNumUtil.generateRandomNum();
        boolean moving = false;
        if (num >= 4) {
            moving = true;
            return moving;
        }
        return moving;
    }

    public HashMap<String, String> judgeResult() {

        for (String car : gameResult.keySet()) {
            if (judgeMove()) {
                gameResult.put(car, gameResult.get(car) + FORWARD_MOVING);
            }
        }
        return gameResult;
    }
    public List<String> judgeWinners(){

    }


}
