package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CarInput {
    public List<String> inputCar() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String[] car = Console.readLine().split(",");
        ValidCheck.namesize_check(car);

        return new ArrayList<>(Arrays.asList(car));
    }

    public int inputNumberOfMove(){
        System.out.println("시도할 회수는 몇회인가요?");
        String input = Console.readLine();

        return ValidCheck.moveTypeCheck(input);
    }
}
