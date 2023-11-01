package racingcar.model;

public class Car implements Comparable<Car>{
    private final String name;
    private int result;

    public Car(String name, int result) {
        this.name = name;
        this.result = result;
    }

    public String getName() {
        return name;
    }

    public int getResult() {
        return result;
    }

    public void updateResult(int count){
        this.result = result + count;
    }

    @Override
    public int compareTo(Car car) {
        return Integer.compare(this.result, car.result);
    }
}
