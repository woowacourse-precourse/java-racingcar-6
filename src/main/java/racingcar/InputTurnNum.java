package racingcar;

import java.util.ArrayList;
import java.util.List;

public class InputTurnNum {

    private Result result = new Result();

    public void inputTurn(String input, List<Car> carList) {
        try {
            if (input == null || input.isEmpty()) {
                throw new IllegalArgumentException("입력한 값이 없습니다.");
            }

            int turn = Integer.parseInt(input);

            if (turn <= 0) {
                throw new IllegalArgumentException("입력한 값이 1이상이 아닙니다.");
            }

            result.printResult(turn, carList);


        } catch (NumberFormatException e) {
            // TODO: 에러메시지 출력 안되는 부분 리팩토링
            throw new IllegalArgumentException("입력한 값이 정수로 변환될 수 없습니다.");

        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
            throw e;
        }

    }
}

