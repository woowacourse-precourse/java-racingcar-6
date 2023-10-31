package racingcar;

public class Car {
    private String Name;
    private int Straight;
    public Car(){
        Straight = 0;
    }

    public void addStraight(){
        Straight++;
    }

    public int getStraight() {
        return Straight;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }
}
