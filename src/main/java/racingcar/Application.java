package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Application {

    private static final View view = new View();
    private static final Game game = new Game();

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        view.printStart();
        List<String> inputCarName = Arrays.stream(Console.readLine().split(",")).collect(Collectors.toList());
        List<Car> carList = createCar(inputCarName);
        Cars cars = new Cars(carList);

        view.printTryCount();
        String tryCount = Console.readLine();
        validTryCount(tryCount);

        game.createForwardList(cars.getSize());
        view.printResult();
        List<String> forwardList = game.play(Integer.parseInt(tryCount), cars.getSize(), cars, view);

        Winners winners = new Winners(new ArrayList<>());
        String winner = winners.getWinner(maxScore(forwardList), forwardList, cars);
        view.printWinner(winner);
    }

    private static int maxScore(List<String> scores) {
        int max = 0;
        for (String score : scores) {
            if (max < score.length()) {
                max = score.length();
            }
        }
        return max;
    }

    private static List<Car> createCar(List<String> inputCarName) {
        List<Car> carList = new ArrayList<>();
        for (String carName : inputCarName) {
            carList.add(new Car(new CarName(carName)));
        }
        return carList;
    }

    private static boolean isNumber(String str) {
        return str.chars().allMatch(Character::isDigit);
    }

    private static void validTryCount(String tryCount) {
        if (!isNumber(tryCount)) {
            throw new IllegalArgumentException("숫자가 아닌 값을 입력할 수 없습니다.");
        }
    }

}
