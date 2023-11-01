package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private String carNameStr = "";
    private Car[] cars;

    public void run() {
        getCarName();
        tokenizeCarNames();
        int tryNum = getTryNum();

        for (int i = 0; i < tryNum; i++) {
            for (Car car : cars) {
                car.moveForward(Randoms.pickNumberInRange(0, 9));
                String str = car.toString();
                System.out.println(str);
            }
            System.out.println();
        }
        winner();
    }

    private void getCarName() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        carNameStr = Console.readLine();
    }

    private void tokenizeCarNames() {
        String[] carNames = carNameStr.split(",");
        cars = new Car[carNames.length];
        for (int i = 0; i < carNames.length; i++) {
            cars[i] = new Car(carNames[i].trim());
        }
    }

    private int getTryNum() {
        System.out.print("시도할 회수는 몇회인가요? ");
        return Integer.parseInt(Console.readLine());
    }

    private void winner() {
        List<Car> winners = new ArrayList<>();
        int maxForwardCnt = 0;

        for (Car car : cars) {
            int forwardCnt = car.getForwardCnt();

            if (forwardCnt > maxForwardCnt) {
                maxForwardCnt = forwardCnt;
                winners.clear();
                winners.add(car);
            } else if (forwardCnt == maxForwardCnt) {
                winners.add(car);
            }
        }

        System.out.print("최종 우승자: ");
        for (int i = 0; i < winners.size(); i++) {
            System.out.print(winners.get(i).getCarName());
            if (i < winners.size() - 1) {
                System.out.print(", ");
            }
        }
        System.out.println();
    }
}

