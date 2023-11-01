package racingcar;
import racingcar.car.Car;
import java.util.ArrayList;
import java.util.List;


public class Racingcar {
    private List<Car> cars;
    private int rounds;

    public Racingcar(String[] carNames, int rounds) {
        this.rounds = rounds;
        cars = new ArrayList<>();
        for (String carName : carNames) {
            cars.add(new Car(carName));
        }
    }

    public void startRace() {
        for (int i = 0; i < rounds; i++) {
            moveCars();
            displayRoundResult();
            System.out.println();
        }
        displayWinners();
    }

    private void moveCars() {
        for (Car car : cars) {
            car.move();
        }
    }

    private void displayRoundResult() {
        for (Car car : cars) {
            car.displayCurrentPosition();
        }
    }

    private void displayWinners() {
        int maxPosition = getMaxPosition();
        List<String> winners = new ArrayList<>();
        for (Car car : cars) {
            if (car.getPosition() == maxPosition) {
                winners.add(car.getName());
            }
        }
        System.out.print("최종 우승자 : ");
        System.out.print(String.join(", ", winners));
    }

    private int getMaxPosition() {
        int max = -1;//명시적 초기화
        for (Car car : cars) {
            if (car.getPosition() > max) {
                max = car.getPosition();
            }
        }
        return max;
    }
}

