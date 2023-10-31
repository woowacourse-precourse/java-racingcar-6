package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;
import racingcar.domain.Car;
import racingcar.domain.Judgment;

public class Application {
    public static void main(String[] args) {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String carNames = Console.readLine();
        String[] array = carNames.split(",");
        List<Car> carList = new ArrayList<>();
        for (String name : array) {
            carList.add(new Car(name));
        }

        System.out.println("시도할 회수는 몇회인가요?");
        int trialCount = Integer.parseInt(Console.readLine());
        Judgment judgment = new Judgment();
        for(int i = 0; i < trialCount; i++) {
            // 경기 한 턴 진행
            judgment.decideMovement(carList);
        }
    }
}
