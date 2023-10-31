package racingcar.model;

import java.util.ArrayList;

public class Race {
    private final int round;
    private final ArrayList<String> carNameList;
    private final  ArrayList<Car> carList = new ArrayList<>();

    public Race(ArrayList<String> carNameList, int round){
        this.carNameList = carNameList;
        this.round = round;
        convertToCar();
    }

    public void convertToCar(){
        carNameList.forEach(carName -> carList.add(new Car(carName)));
    }

    public ArrayList<Car> start() {
        carList.forEach(Car::go);
        return carList;
    }

    public ArrayList<Car> getCarList(){
        return this.carList;
    }

    public ArrayList<String> getWinner(){
        ArrayList<String> winnerList = new ArrayList<>();
        int max = maxPosition(carList);
        for (Car car : carList) {
            if(car.getPosition()==max){
                winnerList.add(car.getName());
            }
        }
        return winnerList;
    }

    public int maxPosition(ArrayList<Car> carList){
        return carList.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(0);
    }

    public int getRound() {
        return round;
    }
}
