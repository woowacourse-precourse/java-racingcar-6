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

    public void racingGameStart() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String stringCarList = carGenerator.inputCarList();

        car.setStringCarList(stringCarList);
        validateInputString();
        car.setCarList(carGenerator.createCarList(stringCarList));
        validateCarName();

        System.out.println("시도할 회수는 몇회인가요?");
        int numberOfAttempts = Integer.parseInt(Console.readLine());
        System.out.println();

        repeatGameForTheNumberOfAttempts(numberOfAttempts);

        System.out.println("최종 우승자 : " + car.getFinalWinner());
    }

    public void validateInputString() {
        car.checkInputStringContainsConsecutiveCommas();
        car.checkInputStringFirstLetterContainsCommas();
        car.checkInputStringLastLetterContainsCommas();
    }

    public void validateCarName() {
        car.checkCarNameLength();
        car.checkCarNameFirstLetterIsSpace();
        car.checkCarNameLastLetterIsSpace();
    }

    public void repeatGameForTheNumberOfAttempts(Integer numberOfAttempts) {
        int currentTryValue = 0;
        LinkedHashMap<String, String> carList = car.getCarList();
        System.out.println("실행 결과");
        while (currentTryValue < numberOfAttempts) {
            randomNumber.setRandomNumberList(randomNumberGenerator.createRandomNumberList(carList));
            move.moveTheCar(car.getCarList(), randomNumber.getRandomNumberList());
            move.stopTheCar(car.getCarList(), randomNumber.getRandomNumberList());
            car.getCurrentRacingResult();
            System.out.println();
            currentTryValue++;
        }
    }
}
