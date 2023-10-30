package racingcar;

public class Car {
    String name;
    int distance;

    public Car(String name, int distance){
        this.name = name;
        this.distance = distance;
    }

    @Override
    public String toString() {
        String result = name + " : ";
        for (int i = 0; i < distance; i++) {
            result += "-";
        }
        return result;

    }
}
