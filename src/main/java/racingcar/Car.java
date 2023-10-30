package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.HashMap;
import java.util.Map;

public class Car {

    public Map<String, Integer> namesOfCars(){
        Map<String, Integer> names = new HashMap<>();
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String inputValue = Console.readLine();

        for(String name : inputValue.split(",")){
            names.put(name,0);
            if(name.length()>=5){
                throw new IllegalArgumentException("자동차 이름이 5자 이하가 아닙니다.");
            }
        }
        return names;
    }
}
