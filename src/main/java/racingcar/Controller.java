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
}
