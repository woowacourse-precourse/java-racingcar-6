package racingcar.domain;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import camp.nextstep.edu.missionutils.*;

public class Input {
    public List<String> carsName (){
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = Console.readLine();
        return List.of(input.split(","));
    }

    public int numberOfAttempts() {
        System.out.println("시도할 회수는 몇회인가요?");
        return Integer.parseInt(Console.readLine());
    }
}
