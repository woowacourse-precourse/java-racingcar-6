package racingcar.controller;

import racingcar.view.Output;
import racingcar.dto.CarNameRequst;
import racingcar.model.Car;
import racingcar.util.NumberUtil;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class CarController {

    private ArrayList<Car> operatedCars;

    public CarController(){
        this.operatedCars = new ArrayList<Car>();
    }

    public void initializeOperatedCars(List<CarNameRequst> carNames){
        this.operatedCars = createCars(carNames);
    }

    public ArrayList<Car> createCars(List<CarNameRequst> names){

        Set<String> uniqueNames = new HashSet<>();
        List<String> existNames = this.getNames();
        List<Car> newCars = new ArrayList<>();

        for (CarNameRequst nameRequest : names) {
            String name = nameRequest.getName();
            if (existNames.contains(name) || uniqueNames.contains(name)) {
                throw new IllegalArgumentException("중복된 이름은 추가할 수 없습니다.");
            }
            uniqueNames.add(name);
            newCars.add(new Car(name));
        }

        return (ArrayList<Car>) newCars;
    }

    public void round(){
        for(Car car : this.operatedCars){
            car.tryForwardChance();
        }
        Output.printRoundResult(this.operatedCars);
    }

    public void determineWinner(){
        int maxValue = NumberUtil.getMaximumNum(getOperatedCarPositions());
        ArrayList<Car> winners = getNameOfWinners(maxValue);
        printWinners(winners);
    }

    private ArrayList<String> getNames(){
        return operatedCars.stream()
                .map(Car::getName)
                .collect(Collectors.toCollection(ArrayList::new));
    }

    private ArrayList<String> getNames(ArrayList<Car> cars){
        return cars.stream()
                .map(Car::getName)
                .collect(Collectors.toCollection(ArrayList::new));
    }

    private ArrayList<Car> getNameOfWinners(int maxPosition){
        return operatedCars.stream()
                .filter(x-> x.getPosition() == maxPosition)
                .collect(Collectors.toCollection(ArrayList::new));
    }

    private ArrayList<Integer> getOperatedCarPositions(){
        return operatedCars.stream()
                .map(Car::getPosition)
                .collect(Collectors.toCollection(ArrayList::new));
    }

    private void printWinners(ArrayList<Car> winners){
        Output.printFinalWinner();
        if(winners.size() == 1){
            Output.printSingleWinner(winners.get(0));
        }
        else{
            Output.printMultiWinner(winners);
        }
    }

}
