package racingcar.service;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import racingcar.data.Car;

public class CarService {
    private List<Car> carList = new ArrayList<>();
    private int round;

    public void start() {
        carList = getCarList();
        round = getRound();

        System.out.println("실행 결과");
        while (round-- > 0) {
            carList.forEach(res -> {
                res.move(isPossibleMove());
            });
            System.out.println();
        }

        int max = -1;
        List<String> winnerList = new ArrayList<>();
        for (Car car : carList) {
            if (max < car.getMoveDistance()) {
                max = car.getMoveDistance();
                winnerList.clear();
                winnerList.add(car.getName());
            } else if (max == car.getMoveDistance()) {
                winnerList.add(car.getName());
            }
        }

        String winnerString = winnerList.get(0);
        for (int i = 1; i < winnerList.size(); i++) {
            winnerString += ", " + winnerList.get(i);
        }

        System.out.println("최종 우승자 : " + winnerString);
    }

    private List<Car> getCarList() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String[] inputs = Console.readLine().split(",");

        List<Car> carList = new ArrayList<>();
        for (String input : inputs) {
            if (input.length() > 5) {
                throw new IllegalArgumentException();
            }

            carList.add(new Car(input, 0));
        }

        return carList;
    }

    private int getRound() {
        System.out.println("시도할 회수는 몇회인가요?");
        try {
            return Integer.parseInt(Console.readLine());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }

    private boolean isPossibleMove() {
        return Randoms.pickNumberInRange(0, 9) >= 4;
    }
}
