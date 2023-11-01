package racingcar.domain;

public class Car {

    private String name;
    private Integer position = 0;

    public Car(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Integer getPosition() {
        return position;
    }

    public Integer move(int randomNum) {
        if(randomNum >= 4)
            position++;

        return position;
    }

    @Override
    public String toString() {
        String result = "";
        for (int i = 0; i < position; i++) {
            result += "-";
        }
        return name + " : " + result;
    }
}
