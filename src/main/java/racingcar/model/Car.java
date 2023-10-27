package racingcar.model;

public class Car {
    private String name;
    private int location = 0;

    public Car(String name) {
        if (name == null) {
            throw new IllegalArgumentException("이름이 null이 될 수 없습니다!");
        }
        if (name.length() > 5 || name.length() < 1) {
            throw new IllegalArgumentException("이름은 5자 이상이 될 수 없습니다!");
        }
        if (!name.matches("^[a-zA-Z가-힣]*$")) {
            throw new IllegalArgumentException("입력값은 영어나 한글만 가능합니다.");
        }
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void goOrStop(int i) {
        if(i>3) {
            location++;
        }
    }

    public int getLocation() {
        return location;
    }
}
