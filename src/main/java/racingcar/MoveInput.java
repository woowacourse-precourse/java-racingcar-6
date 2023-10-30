package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class MoveInput {
    private final String move;

    MoveInput() {
        System.out.println("시도할 횟수는 몇회인가요?");
        move = Console.readLine();
    }

    public boolean isValidLength() {
        return move.length() == 1;
    }

    public boolean isDigit() {
        return (move.charAt(0) >= '0' && move.charAt(0) <= '9');
    }


    public void moveException() throws IllegalArgumentException {
        if (!isValidLength()) throw new IllegalArgumentException();
        if (!isDigit()) throw new IllegalArgumentException();
    }

    public int getMove() {
        return Integer.parseInt(move);
    }

}
