package racingcar.controller;

import camp.nextstep.edu.missionutils.Console;
import racingcar.domain.Racing;
import racingcar.util.CheckInput;

import java.util.*;

public class RacingController {
    private final CheckInput checkInput = new CheckInput();
    private final Racing racing = new Racing();

    public void start() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String nameOfCars = Console.readLine();
        
        System.out.println("시도할 횟수는 몇회인가요?");
        int trials = Integer.parseInt(Console.readLine());

        List<String> players = CheckInput.check(nameOfCars);
        racing.play(players, trials);
    }
}
