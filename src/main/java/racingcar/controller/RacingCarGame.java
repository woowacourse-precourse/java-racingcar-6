package racingcar.controller;

import racingcar.model.Car;
import racingcar.model.Validator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class RacingCarGame {
    private Car car;
    private Validator validator;
    private int[] count;

    public RacingCarGame() {
        validator = new Validator();
        count = new int[splitCarNamesByComma().size()];
    }

    public List<String> splitCarNamesByComma() {
        List<String> carNameList = new ArrayList<>();

        String carName = InputView.getCarNameFromPlayer();
        if (validator.isCarNameFromPlayerValidate(carName)) {
            String[] carNameArray = carName.split(",");
            for (int i = 0; i < carNameArray.length; i++) {
                carNameList.add(carNameArray[i]);
            }
        }
        return carNameList;
    }



}
