package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String inputName = Console.readLine();

        List<Car> carList = parseInputName(inputName);
        System.out.println(inputName);

    }

    public static List<Car> parseInputName(String inputName) {
        List<Car> carList = new ArrayList<>();
        String arrName[] = inputName.split(",");

        for(String name : arrName){
            if(name.length() > 5){
                throw new IllegalArgumentException();
            }
            Car car = new Car(name);
            carList.add(car);
        }

        return carList;
    }
}
