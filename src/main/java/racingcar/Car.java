package racingcar;
import camp.nextstep.edu.missionutils.Console;

public class Car {
    String inputCarName(){
        return Console.readLine();
    }

    String[] splitCarName(String cars){
        return cars.split(",");
    }
}
