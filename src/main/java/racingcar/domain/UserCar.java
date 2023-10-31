package racingcar.domain;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class UserCar {
    private Map<String, Integer> car;
    public UserCar(){
    }

    public void inputCarName(){
        Map<String, Integer> car = new HashMap<>();

        String str = Console.readLine();
        String[] arrStr = str.split(",");

        for(int i=0; i<arrStr.length; i++){
            car.put(arrStr[i],0);
        }
        this.car = car;
    }
}

