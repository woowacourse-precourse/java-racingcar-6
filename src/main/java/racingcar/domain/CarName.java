package racingcar.domain;

public class CarName {

    private final String name;

    public CarName(String name) {
        this.name = confirm(name);
    }

    private String confirm(String name) {
        blankCheck(name);
        noNameCheck(name);
        nameLengthCheck(name);
        return name;
    }

    private void blankCheck(String name) {
        if (name.contains(" ")) {
            throw new IllegalArgumentException("[ERROR] 이름에는 공백이 포함될 수 없습니다.");
        }
    }

    private void noNameCheck(String name) {
        if (name.length() == 0) {
            throw new IllegalArgumentException("[ERROR] 이름은 비어있을 수 없습니다.");
        }
    }

    private void nameLengthCheck(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException("[ERROR] 이름은 5자 이하만 입력할 수 있습니다.");
        }
    }

    public String getName() {
        return name;
    }
}
