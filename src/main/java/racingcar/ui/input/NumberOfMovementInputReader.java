package racingcar.ui.input;

import camp.nextstep.edu.missionutils.Console;

/**
 * @author 민경수
 * @description number of movement input reader
 * @since 2023.10.27
 **********************************************************************************************************************/
public class NumberOfMovementInputReader{

    public int readLine() {
        System.out.println("시도할 회수는 몇회인가요?");

        return convertToInteger(Console.readLine());
    }

    private int convertToInteger(String number) {
        if (number.equals("0")) {
            throw new IllegalArgumentException("시도 횟수는 0보다 커야 합니다.");
        }

        try {
            return Integer.parseInt(number);
        } catch (Exception e) {
            throw new IllegalArgumentException("입력한 값을 확인해주세요. 값 : " + number);
        }
    }

}