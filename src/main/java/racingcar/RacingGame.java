package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class RacingGame {
    List<Car> cars = new ArrayList<>();
    Output output = new Output();

    public void start() {
        List<Car> winners;
        int tryCount;

        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String[] carNames = Console.readLine().split(",");
        inputCarName(carNames);

        System.out.println("시도할 횟수는 몇회인가요?");
        String tryNumber = Console.readLine();
        tryCount = inputTry(tryNumber);

        System.out.println("\n실행 결과");
        progress(tryCount);

        System.out.print("최종 우승자 : ");
        winners = getWinner(cars);
        System.out.println(output.winner(winners));
    }

    public void inputCarName(String[] carNames) {
        for (String name : carNames) {
            name = Extention.modify.removeSpace(name);
            Error.check.isFiveLengthBelow(name.length());

            cars.add(new Car(name));
        }
    }

    public int inputTry(String tryNumber) {
        Error.check.isAllInteger(tryNumber);

        return Integer.parseInt(tryNumber);
    }

    public void progress(int tryCount) {
        if (tryCount <= 0) {
            return;
        }
        for (Car car : cars) {
            int randomNumber = Randoms.pickNumberInRange(0, 9);
            car.forward(randomNumber);

            String carState = output.carSituation(car);
            System.out.println(carState);
        }
        System.out.println();

        progress(tryCount - 1);
    }

    public List<Car> getWinner(List<Car> cars) {
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
