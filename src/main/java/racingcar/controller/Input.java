package racingcar.controller;

import racingcar.model.Race;

import java.util.ArrayList;
import java.util.List;

public class Input {
    public List<String> carInput(String carInput){
        return splitNames(carInput);
    }

    private List<String> splitNames(String carInput) {

        String[] carArray = carInput.split(",");
        List<String> carNames = new ArrayList<>();

        for (String carName : carArray) {
            carNames.add(carName.trim());
        }
        return carNames;
    }
}
