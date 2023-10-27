package racingcar;

import java.util.HashMap;
import racingcar.view.inputView;
import racingcar.view.outputView;

public class Application {
    public static void main(String[] args) {
        inputView inputView = new inputView();
        outputView outputView = new outputView();
        HashMap<String, Integer> carNameHashMap = new HashMap<>();

        String carName = inputView.gameStart();
        String[] carNameArray = carName.split(",");

        for (int i = 0; i < carNameArray.length; i++) {
            carNameHashMap.put(carNameArray[i],0);
        }

        String askCount = inputView.gameStart();
        Integer count = Integer.parseInt(askCount);

        outputView.resultView(count,carNameHashMap);
    }
}
