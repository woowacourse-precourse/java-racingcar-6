package racingcar.domain;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;
import static java.util.stream.LongStream.iterate;

import java.util.Map;
import java.util.Set;

public class CarsGameResult {

    private final Map<String, Integer> result;

    public CarsGameResult(Map<String, Integer> carsMaps, int carsGameCount) {
        this.result = generateResult(carsMaps, carsGameCount);
    }

    private Map<String, Integer> generateResult(Map<String, Integer> carsMaps, int carsGameCount) {
        Map<String, Integer> carsGameResult = carsMaps;
        iterate(0, i -> i + 1).limit(carsGameCount).forEach(i -> calculateResult(carsGameResult));
        return carsGameResult;
    }

    private void calculateResult(Map<String, Integer> carsGameResult) {
        Set<String> cars = carsGameResult.keySet();
        for (String car : cars) {
            putResult(carsGameResult, car);
        }
    }

    private void putResult(Map<String, Integer> carsGameResult, String car) {
        if (pickNumberInRange(0, 9) < 4) {
            int forward = carsGameResult.get(car) - 1;
            carsGameResult.put(car, forward);
        }
    }

    public Map<String, Integer> getResult() {
        return result;
    }
}
