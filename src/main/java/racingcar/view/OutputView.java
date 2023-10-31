package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Iterator;
import java.util.Map;
import racingcar.model.domain.Car;

public class OutputView {
    public void requestCarName() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    public void requestNumberOfAttempts() {
        System.out.println("시도할 회수는 몇회인가요?");
    }

    public void printStartCarRace() {
        System.out.println("\n실행결과");
    }

    public void printCar(Car car) {
        Map<String, Integer> carName = car.getName();
        Iterator<String> keys = carName.keySet().iterator();

        while (keys.hasNext()) {
            String key = keys.next();
            System.out.print(key + " : ");
            for (int i = 0; i < car.getName().get(key); i++) {
                System.out.print("-");
            }
            System.out.println();
        }
        System.out.println();
    }

    public void printWinner(String winner) {
        System.out.print("최종 우승자 : " + winner);
        Console.close();
    }
}
