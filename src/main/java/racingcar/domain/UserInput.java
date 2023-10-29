package racingcar.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class UserInput {

    public List<String> askCar() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        List<String> carTypeList = new ArrayList<String>();
        for (String carType: input.split(",")){
            checkLength(carType);
            carTypeList.add(String.valueOf(carType));
        }
        return carTypeList;

    }

    public void checkLength(String carType){
        if (carType.length() > 5){
            throw new IllegalArgumentException("자동차 이름은 5글자 보다 적어야 합니다.");
        }
    }


}
