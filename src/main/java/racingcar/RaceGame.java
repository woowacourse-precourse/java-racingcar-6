package racingcar;

import util.Converter;

import java.util.List;

public class RaceGame {
    private final Referee referee;
    private final NumberGenerator numberGenerator;
    private final RaceGameValidator raceGameValidator;
    private static final String WINNERS_MESSAGE = "최종 우승자 : ";
    private static final String RESULT_MESSAGE =  "실행 결과";
    private static final String DELIMITER_FOR_OUTPUT = ", ";
    private static final String DELIMITER_FOR_INPUT = ",";
    private static final int MIN_RANGE = 0;
    private static final int MAX_RANGE = 9;

    public RaceGame() {
        this.referee = new Referee();
        this.numberGenerator = new NumberGenerator(MIN_RANGE, MAX_RANGE);
        this.raceGameValidator = new RaceGameValidator();
    }

    public void run(String carsName, int tryNum) {
        raceGameValidator.tryNum(tryNum);
        List<Car> cars = makeCars(carsName);
        System.out.println(RESULT_MESSAGE);
        for (int i = 0; i < tryNum; i++) {
            round(cars);
            System.out.println();
        }
        List<String> winners = referee.judgeWinners(cars, Calculator.maxMove(cars));
        printWinners(winners);
    }

    private void round(List<Car> cars) {
        cars.forEach(car -> {
            int randomNumber = numberGenerator.randomNumber();
            boolean isMove = referee.judgeMoveOrStop(randomNumber);
            car.moveOrStop(isMove);
        });
    }

    private void printWinners(List<String> winners) {
        System.out.print(WINNERS_MESSAGE);
        String winnerList = String.join(DELIMITER_FOR_OUTPUT, winners);
        System.out.println(winnerList);
    }

    private List<Car> makeCars(String carsName) {
        return Converter.stringToStringList(carsName, DELIMITER_FOR_INPUT).stream().map(Car::new).toList();
    }
}
