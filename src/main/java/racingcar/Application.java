package racingcar;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {

        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");

        CarList carList = new CarList();
        carList.setCarName();
        if (!carList.checkCarName()) throw new IllegalArgumentException();
        List<String> carArrayList = carList.getCarList();

        RacingNumber racingNumber = new RacingNumber();
        racingNumber.setRacingNum();
        if(!racingNumber.isPositiveInteger()) throw new IllegalArgumentException();
        int racingNum = racingNumber.getRacingNum();

        CarRacing carRacing = new CarRacing(carArrayList);
        for(int i = 0; i < racingNum; i ++){
            carRacing.setRacingMap();
            carRacing.printRacingProgress();
        }
        carRacing.printRacingResult();


    }
}
