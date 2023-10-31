package racingcar.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import camp.nextstep.edu.missionutils.Console;

public class CarGenerator {
    public CarGenerator(){}
    public List<String> askCarName(){
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        List<String> carName = Arrays.asList(Console.readLine().split(","));
        for(String name : carName){
            if(name.length()>5){
                throw new IllegalArgumentException();
            }
            if(Collections.frequency(carName,name)>1){
                throw new IllegalArgumentException();
            }
        }
        return carName;
    }
    public List<Car> createCars(List<String> carNames){
        List<Car> racingCarList = new ArrayList<>();
        for(String name : carNames){
            Car newCar = new Car(name);
            racingCarList.add(newCar);
        }
        return racingCarList;
    }
}
