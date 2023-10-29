package racingcar.service;

import camp.nextstep.edu.missionutils.Console;
import racingcar.domain.Car;
import racingcar.domain.CarGenerator;
import racingcar.domain.RandomNumber;
import racingcar.domain.RandomNumberGenerator;

import java.util.LinkedHashMap;

public class RacingGame {

    Car car = new Car();
    CarGenerator carGenerator = new CarGenerator();
    RandomNumber randomNumber = new RandomNumber();
    RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();
    Move move = new Move();


    public void RacingGameStart() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        carGenerator.inputCarList();
        car.checkContainsConsecutiveCommas();
        car.setCarList(carGenerator.createCarList());
        car.checkCarNameLength();
        car.checkCarNameDuplicate();
        car.checkCarNameFirstLetterIsSpace();
        car.checkCarNameLastLetterIsSpace();
        LinkedHashMap<String, String> carList = car.getCarList();

        System.out.println("시도할 회수는 몇회인가요?");
        int numberOfAttempts = Integer.parseInt(Console.readLine());
        System.out.println();
        int tryValue = 0;

        System.out.println("실행 결과");
        while (tryValue < numberOfAttempts) {
            randomNumber.setRandomNumberList(randomNumberGenerator.createRandomNumberList(carList));
            move.moveTheCar(car.getCarList(), randomNumber.getRandomNumberList());
            move.stopTheCar(car.getCarList(), randomNumber.getRandomNumberList());
            car.getCurrentRacingResult();
            System.out.println();
            tryValue++;
        }
        System.out.println("최종 우승자 : " + car.getFinalWinner());
    }
}
