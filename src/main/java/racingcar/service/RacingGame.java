package racingcar.service;

import camp.nextstep.edu.missionutils.Console;
import racingcar.domain.Car;
import racingcar.domain.CarGenerator;
import racingcar.domain.RandomNumber;
import racingcar.domain.RandomNumberGenerator;

public class RacingGame {

    Car car = new Car();
    CarGenerator carGenerator = new CarGenerator();
    RandomNumber randomNumber = new RandomNumber();
    RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();


    public void RacingGameStart() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        carGenerator.setCarListToCar();

        System.out.println("시도할 회수는 몇회인가요?");
        int numberOfAttempts = Integer.parseInt(Console.readLine());
        int tryValue = 0;

        System.out.println("실행 결과");
        while (tryValue < numberOfAttempts) {

        }
    }
}
