package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class Race {

    private static final int MIN_RANDOM = 0;
    private static final int MAX_RANDOM = 9;
    private static final int END_OF_FORWARD = 4;
    private final List<Car> cars;
    private final int count;
    private static String carNames;
    private static int cnt;

    Computer computer = new Computer();
    FindWinners findWinners = new FindWinners();


    public Race() {
        this.cars = null;
        this.count = 0;
    }

    public Race(String carNames, int count) {
        this.cars = computer.createCars(carNames);
        this.count = count;
    }

    public Race InputForStart() {
        carNames = computer.getInputCarNames();
        cnt = computer.getInputRaceCount();

        return new Race(carNames, cnt);
    }

    public void play() {
        for(int i = 0; i < count; i++) {
            playOneRound();
            printRoundResult();
        }
        printWinners();
    }

    public void playOneRound() {
        for (Car car : cars) {
            int randomNumber = createRandomNumber();
            if(randomNumber >= END_OF_FORWARD) {
                car.forward();
            }
        }
    }

    public int createRandomNumber() {
        return Randoms.pickNumberInRange(MIN_RANDOM,MAX_RANDOM);
    }

    public void printRoundResult() {
        for (Car car : cars) {
            System.out.println(car.getName() + " : " + "-".repeat(car.getPosition()));
        }
        System.out.println();
    }

    private void printWinners() {
        List<Car> winners = findWinners.getWinners(cars);
        Computer.printWinners(winners);
    }
}