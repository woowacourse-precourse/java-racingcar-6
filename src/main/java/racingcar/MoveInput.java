package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class MoveInput {
    private final String move;

    MoveInput() {
        System.out.println("시도할 횟수는 몇회인가요?");
        move = Console.readLine();
    }

    public int getMove() {
        return Integer.parseInt(move);
    }

    public void exceptionHandling() throws IllegalArgumentException {
        try {
            Integer.parseInt(move);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException();
        }
    }

}
