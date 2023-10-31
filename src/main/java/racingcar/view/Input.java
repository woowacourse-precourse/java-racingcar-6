package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.model.Car;

import java.util.*;
import java.util.stream.Collectors;

public class Input {

    public String askCars(){
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        return Console.readLine();
    }

    public String askTimes(){
        System.out.println("시도할 회수는 몇회인가요?");
        return Console.readLine();
    }

}
