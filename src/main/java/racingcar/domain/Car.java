package racingcar.domain;

public class Car {

    private final String name;
    private String position;

    // TODO: 정적 팩토리 메서드 활용하기
    public Car(String name) {

        this.name = name;
        this.position = "";
    }
}
