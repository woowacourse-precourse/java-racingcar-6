package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;


public class Car {
    public String[] carname(){
        System.out.println("자동차 이름을 입력하세요");
        String name = Console.readLine();
        String[] carnames = name.split(",");
        System.out.println(Arrays.toString(carnames));
        return carnames;
    }
}
