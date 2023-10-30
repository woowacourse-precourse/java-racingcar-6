package racingcar;

import java.util.ArrayList;

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
        for(String name : names){
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

}
