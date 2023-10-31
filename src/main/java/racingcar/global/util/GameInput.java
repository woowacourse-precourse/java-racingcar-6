package racingcar.global.util;

import static camp.nextstep.edu.missionutils.Console.readLine;

import java.util.Arrays;

public final class GameInput {

    public static int inputRoundCnt() {
        System.out.println("시도할 회수는 몇회인가요?");
        String input = readLine();
        return validateCnt(input);
    }

    public static int validateCnt(String input) {
        if (input.isEmpty()) {
            throw new IllegalArgumentException("입력 값이 비어 있습니다.");
        }

        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자 형식이 올바르지 않습니다.");
        }
    }

    public static String[] inputCarList() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String[] carList = readLine().trim().split(",\\s*");
        validateCarList(carList);
        return carList;
    }

    public static void validateCarList(String[] carList) {
        if (carList[0].equals("") || carList.length == 0) {
            throw new IllegalArgumentException("입력 값이 비어 있습니다.");
        }

        for (String s : carList) {
            if (s.length() > 5) {
                throw new IllegalArgumentException("자동차 이름은 5자 이하만 가능합니다.");
            }
        }
    }
}
