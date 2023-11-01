package racingcar.service;

import static racingcar.service.InputService.attemptCount;
import static racingcar.service.InputService.carList;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import racingcar.util.MovementPolicy;

public class GameService {
    public static Map<String, String> racingResult;

    public static void game() { // 전체 게임에 대한 결과
        setInitCars();

        for (int i = 0; i < attemptCount; i++) {
            racing();
        }
    }

    public static void setInitCars() {
        racingResult = new LinkedHashMap<>();

        for (String eachCar : carList) {
            racingResult.put(eachCar, "");
        }
    }

    public static void racing() { // 한 세트에 대한 결과
        for (String eachCar : carList) {
            moving(eachCar);
        }

        printEachRacingResult(racingResult);
    }

    public static void moving(String carName) { // 각 차에 대한 움직임
        MovementPolicy policy = new MovementPolicy();
        boolean canGo = policy.isAvailableToGo();

        if (canGo) {
            racingResult.put(carName, racingResult.get(carName) + "-");
        }
    }

    public static void printEachRacingResult(Map<String, String> racingResult) {
        racingResult.forEach((Key, Value) -> {
            String result = Key + " : " + Value;
            System.out.println(result);
        });
        System.out.println("");
    }

    public static List<String> determineWinner() {
        List<String> winners = new ArrayList<>(racingResult.keySet());

        winners.sort((c1, c2) -> racingResult.get(c2).compareTo(racingResult.get(c1)));

        return winners;
    }
}
