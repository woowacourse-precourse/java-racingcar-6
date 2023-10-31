package racingcar.model.wrapper;

public record CarName(String name) {
    public CarName {
        validateCarName(name);
    }

    private void validateCarName(String name) {
        if (name.isBlank()) {
            throw new IllegalArgumentException("자동차 이름은 비어있을 수 없습니다.");
        }
        if (name.length() > 5) {
            throw new IllegalArgumentException("자동차 이름은 5글자를 초과할 수 없습니다.");
        }
    }
}
