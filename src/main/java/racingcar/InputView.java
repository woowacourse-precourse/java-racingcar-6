package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;

public class InputView {
    public static final int NAME_SIZE = 5;

    public static String carInput() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        return Console.readLine();
    }
    public static String roundInput(){
        System.out.println("시도할 회수는 몇회인가요?");
        return Console.readLine();
    }

    public static String[] InputToArray(String input) throws IllegalArgumentException {
        String[] carsName = input.split(",");

        if (!isNotDuplicate(carsName)) {
            throw new IllegalArgumentException("중복되지 않는 이름을 입력해주세요");
        }

        for (String names : carsName) {
            if (names.length() < 1 || names.length() > NAME_SIZE) {
                throw new IllegalArgumentException("이름은 1글자 이상 5글자 이하여야 합니다.");
            }
        }

        return carsName;
    }

    public static int inputToInt(String roundNum) throws IllegalArgumentException{
        return Integer.parseInt(roundNum);
    }

    public static boolean isNotDuplicate(String[] s) {
        return Arrays.stream(s).distinct().count() == s.length;
    }

}
