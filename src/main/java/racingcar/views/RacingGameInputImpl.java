package racingcar.views;

import camp.nextstep.edu.missionutils.Console;

public class RacingGameInputImpl implements GameInput {

    final static int MAX_NAME_LENGTH = 5;

    private String input() {
        return Console.readLine();
    }

    @Override
    public String[] getNames() {
        String input = input();
        String[] names = input.split(",");
        for (String name : names) {
            validateName(name);
        }
        return names;
    }

    @Override
    public int moveCount() {
        String input = input();
        validateMoveCount(input);
        int count = Integer.parseInt(input);
        if (count < 1) {
            throw new IllegalArgumentException("시도 횟수는 1 이상이어야 한다");
        }
        return count;
    }

    private void validateName(String name) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("자동차 이름은 빈 문자열이 될 수 없다");
        }
        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException("자동차 이름은 5자 이하만 가능하다");
        }
    }


    private void validateMoveCount(String moveCount) {
        try {
            Integer.parseInt(moveCount);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("시도 횟수는 숫자여야 한다");
        }
    }
}
