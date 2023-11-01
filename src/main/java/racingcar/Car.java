package racingcar;

public class Car {
    private String name;
    private int count;
    private Car(){
    }
    public Car(String name) {
        this.name = name;
        this.count = 0;
    }
    public Car(String name, int count) {
        this.name = name;
        this.count = count;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "Car{" +
                "name='" + name + '\'' +
                ", count=" + count +
                '}';
    }
}
