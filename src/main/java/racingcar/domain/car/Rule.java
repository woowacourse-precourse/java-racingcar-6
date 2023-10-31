package racingcar.domain.car;

public interface Rule {
    int getMin();
    int getMax();
    boolean isSucceed(int input);
}
