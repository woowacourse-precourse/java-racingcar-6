package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class InputRacingNumber {
    int inputRacingNumber() throws IllegalArgumentException {
        int number;
        System.out.println("시도할 회수는 몇회인가요?");
        number = Integer.parseInt(Console.readLine());

        if (number <= 0) {
            throw new IllegalArgumentException();
        }
        return number;
    }
}
