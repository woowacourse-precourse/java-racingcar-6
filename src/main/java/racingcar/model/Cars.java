package racingcar.model;

import org.mockito.internal.util.StringUtil;
import racingcar.view.OutputView;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {
    public final ArrayList<Car> CARS = new ArrayList<>();

    public Cars(ArrayList<String> cars){
        cars.forEach(car->CARS.add(new Car(car)));
    }
    public void roundPlay(){
        go();
        OutputView.printRoundResult(new ArrayList<>(CARS.stream()
                .map(Car::getResult)
                .collect(Collectors.toList())
        ));
    }
    public void searchWinner(){
        int maxPosition = CARS.stream()
                .map(Car::getPosition)
                .max(Integer::compareTo)
                .orElse(0);
        List<String> winnerNames = CARS.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .map(Car::getName)
                .collect(Collectors.toList());
        OutputView.printWinner(winnerNames);
    }
    public void go(){
        CARS.forEach(Car::go);
    }
    public ArrayList<Integer> getCarsPosition(){
       ArrayList<Integer> carsPositions = new ArrayList<Integer>();
       for (Car car : CARS) {
           carsPositions.add(car.getPosition());
       }
       return carsPositions;
    }
}
