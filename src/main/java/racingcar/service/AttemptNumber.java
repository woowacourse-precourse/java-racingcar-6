package racingcar.service;

import camp.nextstep.edu.missionutils.Console;

public class AttemptNumber {

    private int number;

    public void inputNumber() {
        System.out.println("시도할 횟수는 몇회인가요?");
        this.number = Integer.parseInt(Console.readLine());
    }

    public int getNum() {
        return number;
    }
}
