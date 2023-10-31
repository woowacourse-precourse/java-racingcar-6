package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {

    List<String> cars;
    public void start(){

        cars = inputCarsName();
        System.out.println(cars);
    }

    private List<String> inputCarsName(){
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        List<String> cars = new ArrayList<String>();
        String line = Console.readLine();

        for(String car : line.split(",")){
            if(car.length() > 5){
                throw new IllegalArgumentException("이름은 5자 이하만 가능합니다.");
            }
            cars.add(car);
        }
        return cars;
    }

}