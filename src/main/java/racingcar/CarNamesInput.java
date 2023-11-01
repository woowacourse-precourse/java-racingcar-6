package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;



public class CarNamesInput {
    public static List<String> namesInput(){
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String[] splitedCarNames = Console.readLine().split(",");
        CheckValidation.validateName(splitedCarNames);
        List<String> carList = Cars.createCarList(splitedCarNames);
        return carList;
    }
}
