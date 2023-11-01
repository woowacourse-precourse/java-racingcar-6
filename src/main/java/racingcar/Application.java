package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현


        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");

        ArrayList<String> cars = Arrays
                .stream(Console.readLine()
                .split(","))
                .collect(Collectors.toCollection(ArrayList::new));

//        for (String car : cars) {
//            System.out.println(car);
//        }

        System.out.println("시도할 회수는 몇회인가요?");
        String tryCount = Console.readLine();





    }


}
