package racingcar;
public final class Car {
    private String name;
    private int distance;

    public static Car create(String name){
        Car car = new Car();
        car.name = name;
        car.distance = 0;
        return car;
    }
    public void run(int randomValue){
        if(randomValue >= 4){
            this.distance ++;
        }
    }
    public String getName() {
        return name;
    }
    public int getDistance() {
        return distance;
    }


    @Override
    public String toString() {
        return "Car{" +
                "name='" + name + '\'' +
                ", distance=" + distance +
                '}';
    }
}
