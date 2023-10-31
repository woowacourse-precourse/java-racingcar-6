package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class RacingGame {
    List<Car> cars = new ArrayList<>();
    Output output = new Output();

    public void start() {
        List<Car> winner;
        int tryCount;

        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        inputCarName(cars);

        System.out.println("시도할 횟수는 몇회인가요?");
        tryCount = inputTry();

        System.out.println("\n실행 결과");
        progress(cars, tryCount);

        System.out.print("최종 우승자 : ");
        winner = getWinner(cars);
        output.winner(winner);
    }

    private void inputCarName(List<Car> cars) {
        String[] carNames = Console.readLine().split(",");
        for (String name : carNames) {
            name = Extention.modify.removeSpace(name);
            Error.check.isFiveLengthBelow(name.length());

            cars.add(new Car(name));
        }
    }

    private int inputTry() {
        String tryNumber = Console.readLine();
        Error.check.isAllInteger(tryNumber);

        return Integer.parseInt(tryNumber);
    }

    private void progress(List<Car> cars, int tryCount) {
        if (tryCount <= 0) {
            return;
        }
        for (Car car : cars) {
            int randomNumber = Randoms.pickNumberInRange(0, 9);
            car.forward(randomNumber);

            output.carSituation(car);
        }
        System.out.println();

        progress(cars, tryCount - 1);
    }

    private List<Car> getWinner(List<Car> cars) {
        List<Car> winners = new ArrayList<>();
        winners.add(cars.get(0));
        for (int i = 1; i < cars.size(); i++) {
            if (cars.get(i).state == winners.get(winners.size() - 1).state) {
                winners.add(cars.get(i));
            }
            if (cars.get(i).state > winners.get(winners.size() - 1).state) {
                winners.removeAll(winners);
                winners.add(cars.get(i));
            }
        }
        return winners;
    }
}
