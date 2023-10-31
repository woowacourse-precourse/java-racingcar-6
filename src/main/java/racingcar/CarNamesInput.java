package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CarNamesInput {
    public static List<String> namesInput(){
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String[] splitedCarNames = Console.readLine().split(",");
        validateName(splitedCarNames);
        List<String> carList = createCarList(splitedCarNames);
        return carList;
    }

    public static void validateName(String[] carNames){
        for(String carName:carNames){
            if(carName.length() > 5){
                throw new IllegalArgumentException("5자리 이하로 입력해주세요.");
            }
        }
    }

    public static List<String> createCarList(String[] carNames){
        List<String> carNameList = new ArrayList<>();
        for(String carName: carNames){
            if(carNameList.contains(carName)){
                throw new IllegalArgumentException("중복된 이름입니다.");
            }
            carNameList.add(carName);
        }
        return carNameList;
    }
}
