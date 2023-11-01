package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import racingcar.domain.Car;
import racingcar.domain.CarGenerator;
import racingcar.domain.Referee;

public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        CarGenerator carGenerator = new CarGenerator();
        List<Car> cars = carGenerator.createCarList(Console.readLine());
        System.out.println("시도할 회수는 몇회인가요?");
        int count = Integer.parseInt(Console.readLine());
        for (int i = 0; i < count; i++) {
            for (Car car : cars) {
                car.moveOrStop();
                System.out.printf("%s : %s\n", car.getName(), car.getDistnace());
            }
            System.out.println();
        }
        Referee referee = new Referee();
        System.out.printf("최종 우승자 : %s", referee.getWinner(cars));
    }
}
