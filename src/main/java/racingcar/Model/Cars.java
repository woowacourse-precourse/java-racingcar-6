package racingcar.Model;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.Util.CarMovement;

public class Cars {

    private int carsLength;
    private List<Car> cars = new ArrayList<>();


    public void addCar(String[] names){
        carsLength = names.length;
        for (String name : names) {
            cars.add(new Car(name));
        }
    }

    public void racingOne(){
        for (Car car : cars){
            moveCar(car);
        }
    }

    private void moveCar(Car car){
        if(CarMovement.movingStatus()){
            car.forwardCarPosition();
        }
    }

    public String getCarName(int index){
        return cars.get(index).getName();
    }

    public String getCarPositionIcon(int index){
        return connectingIcons(cars.get(index));
    }

    private String connectingIcons(Car car){
        String icon = "";
        for(int i = 0; i < car.getCarPosition(); i++){
            icon += "-";
        }
        return icon;
    }

    public List<String> getWinner(){
        int winerPosition = sortPosition().get(0).getCarPosition();
        return getWinnerPositionCar(winerPosition);
    }

    private List<Car> sortPosition(){
        return cars.stream()
                .sorted(Comparator.comparingInt(Car::getCarPosition).reversed())
                .collect(Collectors.toList());
    }

    private List<String> getWinnerPositionCar(int winerPosition){
        return cars.stream()
                .filter(car -> car.isEqualPosition(winerPosition))
                .map(Car::getName)
                .collect(Collectors.toList());
    }
}
