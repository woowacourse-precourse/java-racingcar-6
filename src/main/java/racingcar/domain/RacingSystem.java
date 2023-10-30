package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class RacingSystem {
    User user = new User();

    protected List<String> carNames;
    protected int movement;
    protected List<Car> cars;

    public void makeCarsInstance() {
        cars = new ArrayList<>();
        for (String carName : carNames) {
            Car car = new Car(carName);
            cars.add(car);
        }
    }

    public void printCars() {
        for (Car car : cars) {
            car.printCar();
        }
    }

    public void moveCars() {
        for (Car car : cars) {
            car.move();
        }
    }

    public void raceProgress() {
        for (int i = 0; i < movement; i++) {
            moveCars();
            printCars();
            System.out.println();
        }
    }

    public List<String> makeListOfWinner(int maxMoveState, List<Car> cars) {
        List<String> listOfWinners = new ArrayList<>();
        for (Car car : cars) {
            if (car.getMoveState() == maxMoveState) {
                listOfWinners.add(car.getName());
            }
        }
        return listOfWinners;
    }

    public int findMaxMoveState(int maxMoveState) {
        for (Car car : cars) {
            if (car.getMoveState() > maxMoveState) {
                maxMoveState = car.getMoveState();
            }
        }
        return maxMoveState;
    }

    public void raceWinner() {
        int max = -1;
        int maxMoveState = findMaxMoveState(max);

        System.out.print("최종 우승자 : ");
        System.out.println(String.join(", ", makeListOfWinner(maxMoveState, cars)));
    }

    public void startApp() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        this.carNames = user.inputCarName();
        System.out.println("시도할 회수는 몇회인가요?");
        this.movement = user.inputNumberOfCarMovement();
        System.out.println("실행 결과");
        makeCarsInstance();
        raceProgress();
        raceWinner();
    }
}