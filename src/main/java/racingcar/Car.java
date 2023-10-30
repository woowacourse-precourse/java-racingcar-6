package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {

    private String name;
    private int score;
    final static int MAX_NAME_LENGTH = 5;

    final static int MIN_RANDOM_NUM = 0;
    final static int MAX_RANDOM_NUM = 9;

    final static int FORWARD_CRITERIA = 4;

    public Car(String name) {
        nameValidate(name);
        this.name = name;
        this.score = 0;
    }

    private void nameValidate(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("공백은 이름으로 사용할 수 없습니다.");
        }

        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException("5자 이하의 이름을 입력해주세요.");
        }
    }

    public void move() {
        int rand_num = Randoms.pickNumberInRange(MIN_RANDOM_NUM, MAX_RANDOM_NUM);

        if (rand_num >= FORWARD_CRITERIA) score += 1;
    }
}
