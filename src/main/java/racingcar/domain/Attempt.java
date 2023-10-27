package racingcar.domain;

public class Attempt {

    private Integer count;

    public Attempt(Integer count) {
        this.count = count;
    }

    public boolean isExist() {
        return count > 0;
    }

    public void decrease() {
        count--;
    }

}
