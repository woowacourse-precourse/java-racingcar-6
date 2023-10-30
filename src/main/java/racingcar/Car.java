package racingcar;

public class Car {
    String name;
    int distance;

    public Car(String name, int distance){
        this.name = name;
        this.distance = distance;
    }

    public void move(int randomNumber){
        if(randomNumber >= 4){
            this.distance += 1;
        }
    }

    @Override
    public String toString() {
        return name + " : " + "-".repeat(distance);
    }
}
