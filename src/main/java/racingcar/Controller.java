package racingcar;

import java.util.HashMap;
import racingcar.model.startRacing;
import racingcar.utils.checkException;
import racingcar.view.inputView;
import racingcar.view.outputView;

public class Controller {
    public HashMap<String, Integer> racingCarInputNameController() {
        inputView inputView = new inputView();
        checkException checkException = new checkException();
        HashMap<String, Integer> carNameHashMap = new HashMap<>();

        String carName = inputView.gameStart();
        checkException.checkCommaCarName(carName);

        String[] carNameArray = carName.split(",");
        checkException.checkCarNameException(carNameArray);

        for (int i = 0; i < carNameArray.length; i++) {
            carNameHashMap.put(carNameArray[i], 0);
        }

        return carNameHashMap;
    }

    public Integer racingCarCountController() {
        checkException checkException = new checkException();
        String askCount = inputView.askCount();
        checkException.checkAskCount(askCount);
        Integer count = Integer.parseInt(askCount);

        return count;
    }

    public void racingCarOutputController() {
        outputView outputView = new outputView();
        startRacing startRacing = new startRacing();
        HashMap<String, Integer> carNameHashMap = racingCarInputNameController();
        int count = racingCarCountController();
        String winner = "";

        outputView.resultView();
        for (int i = 0; i < count; i++) {
            startRacing.checkRandomNum(carNameHashMap);
            startRacing.racingResult(carNameHashMap);
        }

        winner = startRacing.realWinner(carNameHashMap);
        outputView.winnerView(winner);
    }
}
