package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GameManager {

    public List<String> inputCarsName(){
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");

        String input = Console.readLine();

        List<String> carsName = new ArrayList<>(Arrays.asList(input));

        return carsName;
    }

    public int inputTrial(){
        System.out.println("시도할 회수는 몇회인가요?");

        return Integer.parseInt(Console.readLine());
    }
}
