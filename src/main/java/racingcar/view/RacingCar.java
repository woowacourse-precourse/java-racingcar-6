package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.model.Car;
import racingcar.service.Input;
import racingcar.service.Move;
import racingcar.service.Output;
import racingcar.service.Random;

public class RacingCar {

    private final Output output = new Output();
    private final Move move = new Move();

    RacingCar() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String cars = Console.readLine();

        System.out.println("시도할 회수는 몇회인가요?");
        String number = Console.readLine();

        String[] carName = Input.splitCarName(cars);
        int challengeNumber = Input.assignChallengeNumber(number);

        System.out.println();
        System.out.println("실행 결과");

        Car car = new Car(carName);
        int carCount = car.carName.size();

        for (int i=0; i < challengeNumber; i++) {
            for (int index = 0; index < carCount; index++) {

                int moveOrNot = move.moveOrNot();
                car.carDistance[index] += moveOrNot;

                output.printCarStatus(car, index);
            }
            System.out.println();
        }

        output.printWinner(car);
    }
}
