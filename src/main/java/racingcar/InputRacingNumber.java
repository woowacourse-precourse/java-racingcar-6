package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class InputRacingNumber {
    int inputRacingNumber (){
        int number;
        System.out.println("시도할 회수는 몇회인가요?");
        number = Integer.parseInt(Console.readLine());

        return number;
    }
}
