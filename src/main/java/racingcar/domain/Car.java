package racingcar.domain;

public class Car {
    private final String nickname;
    private int position = 0;
    private final int MAXIMUM_NICKNAME_LENGTH = 5;

    public Car(String nickname) {
        validate(nickname);
        this.nickname = nickname;
    }

    private void validate(String nickname) {
        validateNicknameLength(nickname);
        validateIsBlank(nickname);
    }

    private void validateIsBlank(String nickname) {
        if (nickname.isBlank()) {
            throw new IllegalArgumentException("공백만 입력할 수는 없습니다.");
        }
    }

    private void validateNicknameLength(String nickname) {
        if (nickname.length() > MAXIMUM_NICKNAME_LENGTH) {
            throw new IllegalArgumentException("이름은 5자 이하로 입력해야 합니다.");
        }
    }

    public String getNickname() {
        return nickname;
    }

    public int getPosition() {
        return position;
    }

    public void moving() {
        position++;
    }
}
