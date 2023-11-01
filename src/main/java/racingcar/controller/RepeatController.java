package racingcar.controller;

public class RepeatController implements RepeatNumCreator {

    @Override
    public int createRepeatNum(String inputRepeat) {
        int repeatNum = inputRepeatToInt(inputRepeat);
        validateRepeatNum(repeatNum);
        return repeatNum;
    }

    private void validateRepeatNum(int repeatNum) {
        checkRepeatNumRange(repeatNum);
    }

    private int inputRepeatToInt(String inputRepeat) {
        int repeatNum;
        try {
            repeatNum = Integer.parseInt(inputRepeat);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException();
        }
        return repeatNum;
    }

    private void checkRepeatNumRange(int repeatNum) {
        if (repeatNum < 1) {
            throw new IllegalArgumentException();
        }
    }
}
