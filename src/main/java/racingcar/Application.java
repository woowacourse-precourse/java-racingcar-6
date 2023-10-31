package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {

    }

    public static int askTimes() {
        System.out.println("시도할 회수는 몇회인가요?");
        String input = Console.readLine();
        int moveTime = 0;
        try {
            moveTime = Integer.parseInt(input);
        }
        catch (NumberFormatException ex) {
            throw new IllegalArgumentException();
        }
        return moveTime;
    }

}
