package racingcar;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {

        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");

        CarList carList = new CarList();
        carList.setCarName();
        carList.checkCarName();
        List<String> carArrayList = carList.getCarList();


    }
}
