package racingcar;

import java.util.Arrays;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class CarsName {
    private static void printGuide_InputCarsName(){
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    private static List<String> inputCarsName(){
        String input_cars_name = readLine();
        String[] cars_array = input_cars_name.split(",");
        List<String> cars = Arrays.asList(cars_array);

        for(String s : cars){
            s = s.strip();
            if(s.length() < 1 || s.length() > 5)
                throw new IllegalArgumentException("자동차 이름은 1~5자만 가능합니다.");
        }

        return cars;
    }
}
