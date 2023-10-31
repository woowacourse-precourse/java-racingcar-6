package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class CarRaceModel {
    private List<String> results;

    public void initialize(List<String> carNames) {
        results = CarNameColon(carNames);
    }

    public List<String> getResults() {
        return results;
    }

    private List<String> CarNameColon(List<String> carNames) {
        List<String> results = new ArrayList<>();
        for (String carName : carNames) {
            results.add(carName + " : ");
        }
        return results;
    }

    public List<String> calculateWinners() {
        int maxDistance = calculateMaxDistance();
        List<String> winners = new ArrayList<>();
        for (int i = 0; i < results.size(); i++) {
            if (results.get(i).length() - results.get(i).replace("-", "").length() == maxDistance) {
                winners.add(results.get(i).split(":")[0].trim());
            }
        }
        return winners;
    }

    private int calculateMaxDistance() {
        return results.stream()
                .map(result -> result.length() - result.replace("-", "").length())
                .max(Integer::compare)
                .orElse(0);
    }
}
