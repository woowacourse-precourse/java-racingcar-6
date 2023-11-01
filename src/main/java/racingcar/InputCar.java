package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class InputCar {

    public List<String> carName(){
        System.out.println("경주할 자동차 이름을 입력하세요. (이름은 쉼표(,) 기준으로 구분)");
        List<String> carName = new ArrayList<>();
        String input = Console.readLine();

        for(String name : input.split(",")) {
            exceptionCarInput(name);
            carName.add(name);
        }

        return carName;
    }
    public List<Integer> carPosition(Integer num){
        List<Integer> carPosition = new ArrayList<>();

        for(int i = 0; i < num; i++) {
            carPosition.add(0);
        }
        return carPosition;
    }

    public void exceptionCarInput(String str) {
        if(str.length() > 5) {
            throw new IllegalArgumentException("5자보다 많음");
        }
        if(str.length() ==0) {
            throw new IllegalArgumentException("자동차 이름을 입력하지 않음");
        }
    }
}
