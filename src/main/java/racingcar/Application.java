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

        System.out.println("시도할 회수는 몇회인가요?");
        input = Console.readLine();
        int rounds = Integer.parseInt(input);

    }

    public static List<String> getCarNamesFromInput(String input) {
        List<String> cars = new ArrayList<>();
        for(String car : input.split(",")){
            checkLengthOfInput(car);
            cars.add(car);
        }
        return cars;
    }

    public static void checkLengthOfInput(String input){
        if(input.length() > 5){
            throw new IllegalArgumentException();
        }
    }
}
