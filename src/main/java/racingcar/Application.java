package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = Console.readLine();
        List<String> carList = new ArrayList<>(Arrays.asList(input.split(",")));

        for (String car: carList){
            if (car.length() > 5) throw new IllegalArgumentException("자동차 이름은 5글자 이하로 작성해주세요.");
        }
    }
}
