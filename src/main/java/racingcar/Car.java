package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Car {
    public void carRacing(){
        CarName();
    }
    public List<String> CarName() {
        String[] carNameArray = getCarName().split(",");
        List <String> carNameList = new ArrayList<>();
        carNameList.addAll(Arrays.asList(carNameArray));
        return carNameList;
    }
    public String getCarName() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = Console.readLine();
        if(!isContainComma(input)){
            throw new IllegalArgumentException();
        }
        return input;
    }

    public boolean isContainComma(String input){
        if(input.contains(","));{
            return true;
        }
    }
}
