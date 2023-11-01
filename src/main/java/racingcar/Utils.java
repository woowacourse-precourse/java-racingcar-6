package racingcar;


import java.util.ArrayList;
import java.util.List;

public class Utils {

    Exceptions exceptions = new Exceptions();

    private List<Car> cars = new ArrayList<>();

    public List<Car> carNames(String input) {
        String[] carNames = input.split(",");
        for (String carName : carNames) {
            exceptions.isInvalidCarNameLength(carName);
            exceptions.isInvalidGapName(carName);
            this.cars.add(new Car(carName));
        }
        return cars;
    }

    public void race(String input) {
        int num = Integer.parseInt(input.substring(0, input.length()));
        System.out.println("실행 결과");
        for (int i = 0; i < num; i++) {
            for (Car car : cars) {
                car.moveOne();
                carPosition(car);
            }
            System.out.println();
        }
    }

    public void carPosition(Car car) {
        System.out.print(car.getName() + " : ");
        for (int i = 0; i < car.getMove(); i++) {
            System.out.print("-");
        }
        System.out.println();
    }

    public void finalWinner() {
        int winnerMove = 0;
        List<String> winners = new ArrayList<>();
        for (Car car : cars) {
            if (car.getMove() > winnerMove) {
                winnerMove = car.getMove();
                winners.clear();
                winners.add(car.getName());
            } else if (car.getMove() == winnerMove) {
                winners.add(car.getName());
            }
        }

        System.out.println("최종 우승자 : " + String.join(", ", winners));
    }

}
