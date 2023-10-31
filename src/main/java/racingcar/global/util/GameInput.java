package racingcar.global.util;

import static camp.nextstep.edu.missionutils.Console.readLine;

import java.util.Arrays;

public final class GameInput {

    public static int inputRoundCnt() {
        System.out.println("시도할 회수는 몇회인가요?");
        String input = readLine();
        return validateCnt(input);
    }

    private static int validateCnt(String input) {
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

    private static void validateCarList(String[] carList) {
        if (carList[0].equals("")) {
            throw new IllegalArgumentException("하나 이상의 차량 이름을 입력해야 합니다.");
        }
    }
}
