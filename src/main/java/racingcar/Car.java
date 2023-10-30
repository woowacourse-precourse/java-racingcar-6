package racingcar;

public class Car {

    private String name;
    private int score;
    final static int MAX_NAME_LENGTH = 5;

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
}
