package racingcar;

import constant.UserResponeMessage;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class CarController {

    private ArrayList<Car> operatedCars;

    public CarController(){
        this.operatedCars = new ArrayList<Car>();
    }

    public void initializeOperatedCars(String[] carNames){
        this.operatedCars = createCars(carNames);
    }

    public ArrayList<Car> createCars(String[] names){
        ArrayList<Car> newCars = new ArrayList<>();
        ArrayList<String> existNames = this.getNames();

        for(String name : names){
            if(existNames.contains(name) || getNames(newCars).contains(name)){
                throw new IllegalArgumentException("중복된 이름은 추가할 수 없습니다.");
            }
            Car car = new Car(name);
            newCars.add(car);
        }
        return newCars;
    }

    public void grantForwardChanceForCars(){
        for(Car car : this.operatedCars){
            car.tryForwardChance();
        }
    }

    public void printRoundResult(){
        for(Car car : this.operatedCars){
            car.printForawrdSituation();
        }
        System.out.println();
    }

    public void determineWinner(){
        Judge judge = new Judge();
        int maxValue = judge.getMaximumNum(getOperatedCarPositions());
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
        System.out.print(UserResponeMessage.FINAL_WINNER_MESSAGE);
        if(winners.size() == 1){
            printSingleWinner(winners.get(0));
        }
        else{
            printMultiWinner(winners);
        }
    }

    private void printSingleWinner(Car winner){
        System.out.print(winner.getName());
    }

    private void printMultiWinner(ArrayList<Car> winners){
        for(int i=0; i<winners.size() -1; i++){
            System.out.print(winners.get(i).getName()+", ");
        }
        System.out.print(winners.get(winners.size() -1).getName());
    }
}
