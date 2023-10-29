package racingcar.model;

public class RepeatNum {
    public int repeatNum;

    public RepeatNum(String inputRepeat) {
        this.repeatNum = createRepeatNum(inputRepeat);
    }

    public int getRepeatNum() {
        return this.repeatNum;
    }

    private int createRepeatNum(String inputRepeat) {
        return validateInputRepeat(inputRepeat);
    }

    private int validateInputRepeat(String inputRepeat) {
        int repeatNum = checkInputRepeatToInt(inputRepeat);
        checkRepeatNumRange(repeatNum);
        return repeatNum;
    }

    private int checkInputRepeatToInt(String inputRepeat) {
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
