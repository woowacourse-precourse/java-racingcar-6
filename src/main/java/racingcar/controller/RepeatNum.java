package racingcar.controller;

import racingcar.view.InputView;

public class RepeatNum {
    public static int setRepeatNum() {
        String inputRepeat = InputView.inputRepeat();
        int repeatNum = checkInputRepeatToInt(inputRepeat);
        checkRepeatNumPlus(repeatNum);

        return repeatNum;
    }

    private static int checkInputRepeatToInt(String inputRepeat) {
        int repeatNum;
        try {
            repeatNum = Integer.parseInt(inputRepeat);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException();
        }
        return repeatNum;
    }

    private static void checkRepeatNumPlus(int repeatNum) {
        if (repeatNum < 1) {
            throw new IllegalArgumentException();
        }
    }
}
