package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        Application application = new Application();
        application.Start();

    }

    public void Start() {
        Application application = new Application();
        Print print = new Print();

        print.printInitName();
        String input = application.input_name();
        String[] split = application.devide_name(input);
        application.exceptionOfNameLength(split);
        Car[] carlist = application.createCar(split);

        print.printInitCount();
        int cnt = Integer.parseInt(Console.readLine());
        for (int i = 0; i < cnt; i++) {
            for (Car car : carlist) {
                application.move(car, Randoms.pickNumberInRange(0, 9));
            }
        }

        print.printResult(carlist);

        List<String> victorylist = compare(carlist);

        print.printVictoryCar(victorylist);

    }

    public String input_name() {
        String input = Console.readLine();
        return input;
    }

    public String[] devide_name(String input) {
        String[] split = input.split(",");
        return split;
    }

    public void exceptionOfNameLength(String[] split) {
        for (String s : split) {
            if (s.length() > 5) {
                throw new IllegalArgumentException();
            }
        }
    }

    public Car[] createCar(String[] split) {
        Car[] carList = new Car[split.length];
        for (int i = 0; i < split.length; i++) {
            carList[i] = new Car(split[i], 0);
        }

        return carList;
    }

    public void move(Car car, int go) {
        if (go >= 4) {
            car.setPos(car.getPos() + 1);
        }
    }

    public List<String> compare(Car[] cars) {

        List<Car> collect = Arrays.stream(cars).sorted(Comparator.comparing(Car::getPos).reversed())
                .collect(Collectors.toList());

        List<String> victorylist = collect.stream().filter((Car car) -> car.getPos() == collect.get(0).getPos())
                .map(v -> v.getName()).collect(Collectors.toList());

        return victorylist;
    }
}
