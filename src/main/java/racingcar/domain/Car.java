package racingcar.domain;

public class Car {
    private String[] names;

    public Car() {
    }

    public Car(String inputName) {
        names = splitNames(inputName);
    }

    private String[] splitNames(String inputName) {
        String[] names = inputName.split(",");
        for (String name : names) {
            if (name.length() > 5) {
                throw new IllegalArgumentException("자동차 이름은 5자 이하로만 가능합니다.");
            }
        }
        return names;
    }

    public String[] getCarNames() {
        return names;
    }
}
