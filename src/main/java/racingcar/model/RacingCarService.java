package racingcar.model;

import java.util.List;
import java.util.Map;

public class RacingCarService {

    public List<String> splitCarName(String userInputCarNames) {
        CarGenerator carGenerator = new CarGenerator(userInputCarNames);
        return carGenerator.generateCarNameList();
    }

    public Map<String, List<Integer>> raceCar(String userInputCarNames, Integer tryNumber) {
        List<String> carNameList = splitCarName(userInputCarNames);
        RacingCarResult moveCarOnce = new RacingCarResult(carNameList, tryNumber);
        return moveCarOnce.getCarPositionMap();
    }

    public Map<String, List<String>> translateResult(String userInputCarNames, String userInputTryNumber) {
        InputValidator.validateNumber(userInputTryNumber);
        int tryNumber = Integer.parseInt(userInputTryNumber);
        RacingCarResultTranslator translator = new RacingCarResultTranslator(raceCar(userInputCarNames, tryNumber),
                tryNumber);
        return translator.translatePositionMap();
    }
}
