package racingcar.domain;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import racingcar.domain.Car;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Referee {
    List<Car> carList = null;
    int carRacingCount = 0;

    public Referee() {
        carList = setCarList();
        carRacingCount = setCarRacingCnt();
    }

    List<String> setCarNameList() {
        String carNames = null;
        List<String> carNameList = null;

        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        carNames = Console.readLine();
        return carNameList = Arrays.asList((carNames.split(",")));
    }

    void carNameError(List<String> carNameList) {
        for (String s : carNameList) {
            if (s.length() > 5)
                throw new IllegalArgumentException();
        }
    }

    List<Car> setCarList() {
        int carCount = 0;
        String carNames = null;
        List<String> carNameList = null;
        List<Car> carList = new ArrayList<>();

        carNameList = setCarNameList();
        carNameError(carNameList);
        carCount = carNameList.size();

        for (int i = 0; i < carCount; i++) {
            carList.add(new Car(carNameList.get(i)));
        }
        return carList;
    }

    int setCarRacingCnt() {
        System.out.println("시도할 회수는 몇회인가요?");
        return Integer.parseInt(Console.readLine());
    }

    public void loopCarRacing() {
        int cnt = 0;

        System.out.println();
        System.out.println("실행 결과");
        while (cnt < carRacingCount) {
            startCarRacing();
            System.out.println();
            cnt++;
        }
    }

    void startCarRacing() {
        for (Car car : carList) {
            int num = Randoms.pickNumberInRange(0, 9);
            if (num >= 4) {
                car.addCarCount();
            }
        }
        for (Car car : carList) {
            System.out.print(car.getName() + " : ");
            for (int j = 0; j < car.getMoveCount(); j++) {
                System.out.print("-");
            }
            System.out.println();
        }
    }

    public void showWinner() {
        List<String> winnerList = new ArrayList<>();
        Car winner = carList.get(0);
        String result = null;

        for (Car car : carList) {
            if (car.getMoveCount() >= winner.moveCount) {
                if (car.getMoveCount() > winner.moveCount) {
                    winnerList.clear();
                }
                winnerList.add(car.getName());
            }
        }

        result = String.join(", ", winnerList);
        System.out.print("최종 우승자 : " + result);
    }

    public List<Car> getCarList() {
        return carList;
    }

    public int getCarRacingCount() {
        return carRacingCount;
    }
}
