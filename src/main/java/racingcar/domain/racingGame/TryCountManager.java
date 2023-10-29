package racingcar.domain.racingGame;

import camp.nextstep.edu.missionutils.Console;

public class TryCountManager {
    public static final int MAX_TRY_COUNT = 100;
    private int tryCount;

    public void makeTryCount() {
        setTryCount(askTryCount());
    }

    private void setTryCount(int tryCount) {
        this.tryCount = tryCount;
    }

    private int askTryCount() {
        printAskTryCount();
        int input = inputTryCount();
        addBlank();
        return input;
    }

    private void addBlank() {
        System.out.println();
    }

    private int inputTryCount() {
        String input = Console.readLine();
        validateTryCount(input);
        return Integer.parseInt(input);
    }

    private boolean isNumeric(String str) {
        return str.chars().allMatch(Character::isDigit);
    }

    private void validateTryCount(String input) {
        if(!isNumeric(input)) {
            throw new IllegalArgumentException("숫자만 입력 가능합니다.");
        }

        if(Integer.parseInt(input) > MAX_TRY_COUNT) {
            throw new IllegalArgumentException("시도 횟수는 최대 " + MAX_TRY_COUNT + "번 가능합니다.");
        }
    }


    private void printAskTryCount() {
        System.out.println("시도할 회수는 몇회인가요?");
    }

    public void invokeForTryCount(Runnable runnable) {
        while (tryCount-- > 0) {
            runnable.run();
        }
    }
}
