package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class Referee {
    private int numOfGame;
    private  List<Car> cars;


    public void setNumOfGame(int numOfGame) {
        this.numOfGame = numOfGame;
    }

    public int getNumOfGame() {
        return numOfGame;
    }

    public List<Car> getCars() {
        return cars;
    }

    public void setCars(String cars) {
        String[] carName = cars.split(",");
        this.cars = parsingCarString(carName);
    }

    private static List<Car> parsingCarString(String[] carName) {
        List<Car> tempCars = new ArrayList<>();
        for (String name : carName) {
            Car car = new Car();
            car.setName(name);
            car.setPosition(0);
            tempCars.add(car);
        }
        return tempCars;
    }

    public void notifyInsertCars(){
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    public void notifyNumOfGame(){
        System.out.println("시도할 회수는 몇회인가요?");
    }

    public void notifyResult(){
        System.out.println("실행 결과");
    }

    public void moveCars(){
        for (Car car : this.cars) {
            car.move();
        }
    }

    public void showCarsStatus(){
        for (Car car : this.cars) {
            System.out.println(car.getName() + " : " + "-".repeat(car.getPosition()));
        }
        System.out.println();
    }
}
