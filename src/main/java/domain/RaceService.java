package domain;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import view.InputView;

public class RaceService {
    private final InputView inputView;
    private final RanNumService ranNumService;

    RaceService() {
        inputView = new InputView();
        ranNumService = new RanNumService();
    }

    private Map<String, Integer> carNamesToMap() {
        Map<String, Integer> carNamesMap = new HashMap<>();
        String carNames = inputView.enterCarNames();
        String[] carNamesList = carNames.split(",");
        for (String carName : carNamesList) {
            carNamesMap.put(carName, 0);
        }
        return carNamesMap;
    }
}
