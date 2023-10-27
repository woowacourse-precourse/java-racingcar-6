package racingcar.racingcar;

/**
 * @author 민경수
 * @description car
 * @since 2023.10.27
 **********************************************************************************************************************/
public class Car {
    private final String name;
    private Integer position;

    public Car(String name, Integer position) {
        validateNameLength(name);

        this.name = name;
        this.position = position;
    }

    private void validateNameLength(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException("자동차 이름은 공백 포함 5글자를 초과할 수 없습니다. 이름을 확인해주세요. 입력한 이름 : " + name);
        }
    }

}