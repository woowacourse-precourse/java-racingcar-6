package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.domain.Car;

import java.util.ArrayList;
import java.util.List;

import static racingcar.domain.Message.HOW_MANY_TIMES;
import static racingcar.domain.Message.INPUT_CAR_NAME;

public class InputView {

    public static List<Car> inputCarName(){
        System.out.println(INPUT_CAR_NAME);
        String cars = Console.readLine();
        return convertToCarList(cars);
    }

    public static int inputTimes() {
        System.out.println(HOW_MANY_TIMES);
        String times = Console.readLine();
        return Integer.parseInt(times);
    }

    
    public static List<Car> convertToCarList(String cars){
        List<Car> res = new ArrayList<>();
        for(String name : List.of(cars.split(","))){
            res.add(new Car(name));
        }
        return res;
    }
    
    

}
