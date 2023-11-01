package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class TryNumber {
    public int getTryNubmers() {
        System.out.println("시도할 회수는 몇회인가요?");
        String inputTryNubmer = Console.readLine();
        checkInputTryNubmer(inputTryNubmer);
        return Integer.parseInt(inputTryNubmer);
    }

    public static void checkInputTryNubmer(String inputTryNumer) {
        try {
            Integer.parseInt(inputTryNumer);
        }catch (NumberFormatException e) {
            throw new IllegalArgumentException("시도할 횟수는 숫자만 입력해주세요. ");
        }

    }

}
