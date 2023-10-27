package racingcar.utils;

public interface NumberGenerator {
    int MIN_NUM = Constraints.MIN_NUM.getValue();
    int MAX_NUM = Constraints.MAX_NUM.getValue();

    // 숫자 생성 메소드
    int generateNumber();
}
