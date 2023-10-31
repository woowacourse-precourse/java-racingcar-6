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
            this.cars.add(new Car(carName));
        }
        return cars;
    }

    public void race(int input) {
        System.out.println("실행 결과");
        for (int i = 0; i < input; i++) {
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

}
