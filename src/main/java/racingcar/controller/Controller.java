package racingcar.controller;

import racingcar.model.Car;
import racingcar.validation.Validation;
import racingcar.view.Input;
import racingcar.view.InputMessage;
import racingcar.utils.Utils;
import racingcar.view.Output;
import racingcar.view.OutputMessage;

import java.util.ArrayList;
import java.util.HashMap;

public class Controller {
    static ArrayList<String> winnerArrayList = new ArrayList<>();

    public static void run() {
        InputMessage.inputCarNames();
        String carNames = Input.getCarNames();
        Validation.validateSeparator(carNames);
        String[] carNamesArray = Utils.splitByComma(carNames);
        Car car = new Car(Utils.arrayToHashMap(carNamesArray));

        InputMessage.inputTryNumber();
        int tryNumber = Utils.stringToInt(Input.getTryNumber());
        OutputMessage.outputResultText();
        while (tryNumber != 0) {
            tryOne(carNamesArray);
            Output.outputGameProgress(Car.getHashMap(), carNamesArray);
            tryNumber--;
        }
        judgeFinalWinner(Car.getHashMap());
        showFinalWinner(winnerArrayList);
    }

    public static void tryOne(String[] carsNameArray) {
        for (String carName : carsNameArray) {
            int randomNumber = Utils.generateRandomNumber();
            Car.move(carName,randomNumber);
        }
    }

    public static void judgeFinalWinner(HashMap<String,String> hashMap) {
        int maxNum = Utils.measureMaxNumInHashMapValues(hashMap);
        for (String key : hashMap.keySet()) {
            judgeEachCar(key, hashMap, maxNum);
        }
    }

    public static void judgeEachCar(String key, HashMap<String,String> hashMap, int maxNum) {
        if (hashMap.get(key).length() == maxNum) {
            winnerArrayList.add(hashMap.get(key));
        }
    }

    public static void showFinalWinner(ArrayList<String> winnerArrayList) {
        if (winnerArrayList.size() == 1) {
            Output.outputFinalSoloWinner(winnerArrayList);
        }
        else if (winnerArrayList.size() > 1) {
            Output.outputFinalJointWinners(winnerArrayList);
        }
    }
}
