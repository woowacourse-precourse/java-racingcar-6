package racingcar.carRacingGame;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class FinalWinner {
    public String finalWinner(Map<String, Integer> carNameMap, List<String> carNameList, int maxLength) {
        List<String> finalWinner = new ArrayList<>();
        for (String carName : carNameList) {
            if (carNameMap.get(carName) == maxLength) finalWinner.add(carName);
        }
        return String.join(",", finalWinner);
    }
}
