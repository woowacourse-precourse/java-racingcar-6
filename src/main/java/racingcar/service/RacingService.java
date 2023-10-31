package racingcar.service;

import java.util.List;
import racingcar.domain.car.Car;
import racingcar.domain.car.Cars;
import racingcar.domain.random.Random;

public class RacingService {
    private Cars cars;
    private Random random;

    public RacingService(){
        this.cars = new Cars();
        this.random = new Random();
    }

    public void generateCars(String userInput) {
        String[] carNames = userInput.split(",");
        for (String carName : carNames) {
            cars.addCar(carName.strip());
        }
    }

    public void playGame(){
        List<Car> allCars = getAllCars();
        for (Car car : allCars) {
            int randomNumber = random.generateRandomNumber();
            ifOver4AndForward(car, randomNumber);
        }
    }

    private void ifOver4AndForward(Car car, int randomNumber) {
        if(randomNumber >= 4 && randomNumber <=9){
            car.forward();
        }
    }

    public List<Car> getAllCars(){
        return cars.getAllCars();
    }

    public void printAllCarsDistance(){
        List<Car> allCars = getAllCars();
        for (Car car : allCars) {
            int carDistance = car.getCarDistance();
            System.out.print(car.getCarName() + " : ");
            printDash(carDistance);
            System.out.println();
        }
    }

    private  void printDash(int carDistance) {
        for(int i = 0; i< carDistance; i++){
            System.out.print("-");
        }
    }

    public String selectWinner() {
        List<Car> allCars = getAllCars();
        Car car = allCars.get(0);
        int winnerDistance = car.getCarDistance();
        String winnerName = car.getCarName();

        for(int i=1; i<allCars.size(); i++){
            car = allCars.get(i);
            if(winnerDistance == car.getCarDistance()){
                winnerName += ", " + car.getCarName();
            }
            if(winnerDistance < car.getCarDistance()){
                winnerDistance = car.getCarDistance();
                winnerName = car.getCarName();
            }
        }
        return winnerName;
    }
}
