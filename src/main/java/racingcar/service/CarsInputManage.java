package racingcar.service;

import java.util.ArrayList;
import java.util.List;
import racingcar.domain.TotalCar;
import racingcar.util.InputManufacture;
import racingcar.view.InputView;

public class CarsInputManage {
    private final InputManufacture manufacture = new InputManufacture();

    public TotalCar makeCars(InputView input) {
        List<String> nameList = makeCarNames(input, manufacture);
        return saveCarList(nameList);
    }

    public ArrayList<String> makeCarNames(InputView input, InputManufacture manufacture) {
        String names = input.readCarNames();
        return manufacture.makeNameList(names);
    }

    public TotalCar saveCarList(List<String> nameList) {
        TotalCar totalCar = new TotalCar();

        for (String name : nameList) {
            totalCar.saveNewCar(name);
        }
        return totalCar;
    }
}
