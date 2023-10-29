package racingcar.model;

public class RacingRepeat {
    private int repeat;

    public RacingRepeat(String repeatString) {
        try {
            int repeat = Integer.parseInt(repeatString);
            if (repeat <= 0) {
                throw new Exception();
            }
            this.repeat = repeat;
        } catch (Exception e) {
            throw new IllegalArgumentException("[Error]: 잘못된 시도횟수 입력");
        }
    }

    public boolean decrease() {
        if (repeat > 0) {
            repeat--;
            return true;
        }
        return false;
    }
}
