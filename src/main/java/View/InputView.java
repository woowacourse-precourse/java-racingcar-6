package View;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public String inputCarName() {
        String carName = null;
        try {
            carName = Console.readLine();
            getCarNameError(carName);
        } catch (Exception a) {
        }
        return carName;
    }

    public void getCarNameError(String carName) {
        if (!carName.contains(",")) {
            throw new IllegalArgumentException("입력한 값에 ','가 포함되어 있지 않습니다.");
        }
    }

    public int inputTryNumber() {
        int tryNum = 0;
        try {
            String input = Console.readLine();
            tryNum = Integer.parseInt(input);
            getTryNumberError(tryNum);
        } catch (Exception a) {
        }
        return tryNum;
    }

    public void getTryNumberError(int tryNum) {
        if (tryNum < 1) {
            throw new IllegalArgumentException("입력한 값은 1 이상이 아닙니다.");
        }
    }
}
