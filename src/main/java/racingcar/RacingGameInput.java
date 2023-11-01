package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RacingGameInput {
    public List<Car> getCarNameInput(List<Car> carList){

        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String cars = Console.readLine();
        List<String> carNameList = Arrays.asList(cars.split(","));
        for (String carName: carNameList) {
            if (carName.length() > 5) {
                throw new IllegalArgumentException("자동차 이름의 길이가 5자가 넘습니다.");
            } else {
                carList.add(new Car(carName, 0));
            }
        }
        return carList;
    }

    public int getTryNumberInput(){

        System.out.println("시도할 회수는 몇회인가요?");
        return Integer.parseInt(Console.readLine());

    }
}
