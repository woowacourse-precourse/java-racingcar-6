package racingcar;

import racingcar.car.Car;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class Race {

    private List<Car> allCars = new ArrayList<>();
    private int turnNum;

    public void start(){
        inputCars();
        inputTurnNum();
        for (int i = 0; i < turnNum; i++) {
            driveCar();
            printResult();
        }
    }

    public void inputCars(){

        System.out.println(Constant.INPUT_CARNAME_MESSAGE);
       String s = Console.readLine();
       String[] cars = s.split(",");

        for (String carName : cars) {
            Car car = new Car(carName,0);
            allCars.add(car);
        }
        validateInputCars();
    }

    public void validateInputCars(){
        validatInputCars_length();
        validateInputCars_type();
    }

    public void validatInputCars_length() {
        for (Car car : allCars) {
            if(car.carName.isEmpty() || car.carName.length()>5){
                throw new IllegalArgumentException();
            }
        }
    }

    public void validateInputCars_type(){
        for (Car car : allCars) {
            if(car.carName.matches("a-zA-Z")){
                throw new IllegalArgumentException();
            }
        }

    }
    public void inputTurnNum(){
        System.out.println(Constant.TURNNUM_INPUT_MESSAGE);

        int number = Integer.parseInt(Console.readLine());
        validateInputTurnNUm(number);
    }

    public void validateInputTurnNUm(int number){
        if(number<1){
            throw new IllegalArgumentException();
        }
    }

    public void driveCar(){
        for (Car car : allCars) {
            car.drive();
        }
    }

    public void printResult(){
        for (Car car : allCars) {
            System.out.print(car.getCarName() + " : ");

            for (int j = 0; j < car.getDistance(); j++) {
                System.out.print("-");
            }
            System.out.println();
        }
        System.out.println();
    }
}