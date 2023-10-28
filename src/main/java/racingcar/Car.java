package racingcar;

public class Car {
    String name;
    int distance;

    Car(String name) {
        this.name = name;
        this.distance = 0;
    }

    @Override
    public String toString() {
        StringBuilder distanceStr = new StringBuilder();
        distanceStr.append(name + " : ");
        for(int i = 0; i < distance; i++) {
            distanceStr.append("-");
        }
        return distanceStr.toString();
    }
}
