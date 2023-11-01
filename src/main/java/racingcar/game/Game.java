package racingcar.game;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import racingcar.domain.Car;
import racingcar.utils.PrintGuide;

public class Game {
    String[] carsInput;
    List<Car> carsList = new ArrayList<>();
    int countInput;

    PrintGuide printGuide = new PrintGuide();

    public void start() {
        printGuide.printInputCarName();
        carsInput = Console.readLine().split(",");
        List<String> carsName = new ArrayList<>(Arrays.asList(carsInput));

        carsName.stream()
                .map(Car::new)
                .forEach(carsList::add);
        printGuide.printInputCount();
        countInput = Integer.parseInt(Console.readLine());
        printGuide.printResult();
        game(carsList, countInput);

    }

    private void game(List<Car> cars, int count){
        while(count-- > 0){
            cars.stream().forEach(car -> race(car));
            cars.stream().forEach(car -> result(car));
            System.out.println();
        }
    }

    private void race(Car car){
        int flag = Randoms.pickNumberInRange(0,9);

        if (flag >= 4){
            car.go();
        }
    }

    private void result(Car car){
        printGuide.printRaceRound(car);
    }
}
