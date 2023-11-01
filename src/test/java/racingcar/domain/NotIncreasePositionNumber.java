package racingcar.domain;

public class NotIncreasePositionNumber implements NumberGenerator {

    @Override
    public int generate() {
        return 3;
    }
}
