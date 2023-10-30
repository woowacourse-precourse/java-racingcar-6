package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

import static racingcar.Constant.*;
import static racingcar.Validation.*;


public class User {
    public List<Car> getCarNames(){
        System.out.print(INPUT_CAR_NAMES_MSG);
        String input = Console.readLine();
        List<String> carStringList = validateCarNames(input);
        List<Car> carList = new ArrayList<>();
        for (String carName : carStringList){
            Car car = new Car(carName);
            carList.add(car);
        }
        return carList;
    }
    public int getMoveNumber(){
        System.out.print(INPUT_MOVE_NUMBER_MSG);
        String input = Console.readLine();
        return validateMoveNumber(input);
    }
}
