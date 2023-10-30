package racingcar;
import camp.nextstep.edu.missionutils.Console;

public class Car {
    String inputCarName(){
        return Console.readLine();
    }

    String[] splitCarName(String cars){
        return cars.split(",");
    }

    boolean isValidate(String[] cars){
        for (String car: cars){
            if (car.length() > 5){
                throw new IllegalArgumentException();
            }
        }
        return true;
    }


}
