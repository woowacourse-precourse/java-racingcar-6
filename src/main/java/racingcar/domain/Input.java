package racingcar.domain;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class Input {

    /**
     * 경주 할 자동차 한줄로 입력 받은 후,
     * 쉽표를 기준으로 나눠서 List에 저장 후 return
     */
    public List<String> createNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String names = Console.readLine();
        return List.of(names.split(","));
    }

    /**
     * 시도 할 횟수 입력 받은 후 return
     */
    public int moveCount() {
        System.out.println("시도할 회수는 몇회인가요?");
        return Integer.parseInt(Console.readLine());
    }
}
