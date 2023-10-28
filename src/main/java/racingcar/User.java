package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class User {
    String inputName(){
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        return Console.readLine();
    }

    List<Car> splitByComma(String inputCarName){
        List<Car> carList = new ArrayList<>();
        String[] cars = inputCarName.split(",");
        for (String carName : cars) {
            carList.add(createCar(carName));
        }
        System.out.println(carList);
        return carList;
    }

    Car createCar(String carName){
        return new Car(carName.trim());
    }


}
