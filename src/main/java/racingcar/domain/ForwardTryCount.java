package racingcar.domain;

public class ForwardTryCount {

    private int count;

    public ForwardTryCount(String countString) {

    }
    private void validate(String countString) {

    }
    private void checkIsNaturalNumber(String countString) {

    }
    private void checkNumeric(String countString) {

    }

    public void subCount () {
        count--;
    }

    public boolean hasZeroCount() {
        return this.count == 0;
    }

}
