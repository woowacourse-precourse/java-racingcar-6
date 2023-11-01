package racingcar.service;

import camp.nextstep.edu.missionutils.Console;

public class AttemptNumber {

    private int number;

    public void inputNumber() {
        try {
            System.out.println("시도할 횟수는 몇회인가요?");
            String input = Console.readLine();

            if (input.isEmpty()) {
                throw new IllegalArgumentException();
            }
            this.number = Integer.parseInt(input);
            if (this.number < 1) {
                throw new IllegalArgumentException();
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }


    public int getNum() {
        return number;
    }
}
