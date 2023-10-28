package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class RacingGame {

    private static final String STARTING_PHRASE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String ATTEMPTING_PHRASE = "시도할 회수는 몇회인가요?";
    private static final String RESULT_PHRASE = "실행 결과";
    private static final String WINNER_PHRASE = "최종 우승자 : ";

    int attemptingNum;

    public void startGame() {
        System.out.println(STARTING_PHRASE);
    }

    public Car[] getInput() {
        String[] carNames = Console.readLine().split(",");
        Car[] cars = createCars(carNames);
        return cars;
    }

    private static Car[] createCars(String[] carNames) {
        Car[] cars = new Car[carNames.length];
        for (int i = 0; i < carNames.length; i++) {
            cars[i] = new Car(carNames[i].trim());
        }
        return cars;
    }

    public void getAttemptingNum() {
        System.out.println(ATTEMPTING_PHRASE);
        attemptingNum = Integer.parseInt(Console.readLine());
    }

    private static void moveCars(Car[] cars, int attemptingNum) {
        for (int i = 0; i < attemptingNum; i++) {
            for (Car car : cars) {
                car.move();
            }
        }
    }

    private static void printRacingGameResults(Car[] cars) {
        System.out.println();
        System.out.println(RESULT_PHRASE);
        for (Car car : cars) {
            System.out.println(car.printResult());
        }
    }

}
