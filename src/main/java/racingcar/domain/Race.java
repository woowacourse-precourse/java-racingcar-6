package racingcar.domain;

import java.util.List;

public class Race {

    private final List<Car> cars;
    private final int tryNum;

    public Race(List<Car> cars, int tryNum){
        this.cars = cars;
        this.tryNum = tryNum;
    }

    public int getTryNum() {
        return tryNum;
    }

    public List<Car> getCars() {
        return cars;
    }

    public int sizeOfCars() {
        return cars.size();
    }

    public void moveCar(int carIndex){
        cars.get(carIndex).move();
    }

    public int getMaxLocationOfCar(){
        int maxLocation = Integer.MIN_VALUE;

        for(Car car : cars){
            if(car.getLocation() > maxLocation) maxLocation = car.getLocation();
        }

        return maxLocation;
    }
}
