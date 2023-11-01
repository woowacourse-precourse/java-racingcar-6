package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class InputCount {
    public Integer countNum(){
        System.out.println("시도할 회수는 몇회인가요?");
        String input = Console.readLine();

        return Integer.parseInt(input);
    }

}
