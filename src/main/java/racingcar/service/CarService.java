package racingcar.service;

import racingcar.object.Car;

import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class CarService {
    public void printGuide_InputCarsName(){
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    public String[] checkCarsNameLength(String input_cars_name){
        if(input_cars_name == null){
            throw new IllegalArgumentException("입력값이 없습니다. 자동차 이름을 입력해주세요.");
        }

        String[] cars_name = input_cars_name.split(",");
        for(String name : cars_name){
            name = name.strip();

            if(name.length() > 5) {
                throw new IllegalArgumentException("자동차 이름은 1~5자만 가능합니다.");
            } else if(name.length() < 1) {
                throw new IllegalArgumentException("공백만을 이름으로 지정할 수 없습니다.");
            }
        }
        return cars_name;
    }

    public List<Car> inputCarsName(){
        String input_cars_name = readLine();
        String[] cars_name = checkCarsNameLength(input_cars_name);

        List<Car> carList = new ArrayList<>();
        for(String name : cars_name){
            carList.add(new Car(name, ""));
        }

        return carList;
    }
}
