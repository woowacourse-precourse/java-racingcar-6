package racingcar.input;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Count {
    public int inputCount() {
        System.out.println("시도할 회수는 몇회인가요?");
        String input = readLine();
        checkExeption(input);
        int count = Integer.parseInt(input);
        return count;
    }
    public void checkExeption(String input) {
        checkIsPositive(input);
        checkEmpty(input);
        checkIsInteger(input);
    }
    public void checkIsPositive(String count) {
        if (Integer.parseInt(count) < 1) {
            throw new IllegalArgumentException();
        }
    }
    public void checkEmpty(String count) {
        if (count.isEmpty()) {
            throw new IllegalArgumentException();
        }
    }
    public void checkIsInteger(String count) {
        try {
            Integer.parseInt(count);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }
}
