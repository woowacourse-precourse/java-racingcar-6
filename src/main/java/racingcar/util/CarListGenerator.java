package racingcar.util;

import java.util.ArrayList;

import racingcar.view.InputView;

public class CarListGenerator {
    InputView inputview = new InputView();
    ArrayList<String> carList = new ArrayList();
    public ArrayList<String> generateCarList() {
        String carNames = inputview.readCarName();

        for (String s : carNames.split(",")) {
            carList.add(s);
        }

        return carList;
    }
}
