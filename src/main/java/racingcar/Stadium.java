package racingcar;

import java.util.List;
import java.util.Arrays;
import java.util.StringJoiner;
import camp.nextstep.edu.missionutils.Randoms;

class Stadium {
    int first_pos;
    List<Car> cars;

    public stadium() {
        first_pos = 0;
        cars = new List<>();
    }

    public void carsEnter(String line) throws IllegalArgumentException {
        carNames = Arrays.asList(line.split(","));
        for (String name : carNames) {
            validateName(name);
            cars.add(new Car(name))
        }
    }

    private static void validateName(String string) throws IllegalArgumentException {
        if (string.length() > 5) {
            throw new IllegalArgumentException();
        }
    }

    public void race() {

    }

    public static int tryMove(Car car) {
        int number = Randoms.pickNumberInRange(0, 9);
        if (forwardSuccessCheck(number)) {
            car.setPos(car.getPos() + 1);
        }
        return car.getPos();
    }

    public static boolean forwardSuccessCheck(int randomNumber) {
        return (randomNumber >= 4);
    }

    public void getStatus() {
        for (Car car : cars) {
            print(showCar(car));
        }
    }

    public static String showCar(Car car) {
        String dash = "-".repeat(car.getPos());
        return String.format("%s: %s", car.getName(), dash);
    }

    private static void print(String s) {
        System.out.println(s);
    }

    public String winner() {
        StringJoiner stringjoiner = new StringJoiner(",");
        for (Car car : cars) {
            if (car.getPos() == first_pos) {
                stringjoiner.add(car.getName());
            }
        }
        return stringjoiner.toString();
    }


}