package racingcar;

public class Car {
    private String name;
    private int distance;

    public Car(String name)
    {
        this.name = name;
    }

    public String getName()
    {
        return this.name;
    }

    public int getDistance()
    {
        return this.distance;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public void setDistance(int distance)
    {
        this.distance = distance;
    }
}
