package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = Console.readLine();
        List<String> cars = getCarNamesFromInput(input);
    }

    public static List<String> getCarNamesFromInput(String input) {
        List<String> cars = new ArrayList<>();
        for(String car : input.split(",")){
            if(car.length() > 5){
                throw new IllegalArgumentException();
            }
            cars.add(car);
        }
        return cars;
    }
}
