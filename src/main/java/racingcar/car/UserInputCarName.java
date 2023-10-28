package racingcar.car;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class UserInputCarName {
    public String inputName() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        return Console.readLine();
    }

    public String[] splitByComma(String inputCarName) {
        return inputCarName.split(",");
    }

    private CarInfo createCar(String carName) {
        return new CarInfo(carName.trim());
    }

    public List<CarInfo> addCarList(String[] cars){
        List<CarInfo> carList = new ArrayList<>();
        for (String carName : cars) {
            carList.add(createCar(carName.trim()));
        }
        return carList;
    }
}
