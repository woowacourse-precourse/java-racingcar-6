package racingcar;

import camp.nextstep.edu.missionutils.*;
import java.util.*;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Map<String, Integer> cars = new HashMap<>();
        List<String> carNames;
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String[] temp = Console.readLine().split(",");
        carNames = new ArrayList<>(Arrays.asList(temp));
    }


}