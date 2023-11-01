package racingcar;

import java.util.List;

public class GameProgress {
    public static void startGame() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        List<String> cars = UserInput.getCarName();

        printGameCountInputMessage();
        int gameCount = UserInput.getGameCount();

        printResultMessage();
        List<Integer> carsPositions = CalculateCarsPositions.initializationCarsPositions(cars);

        carsPositions = printCarsPositionsProgress(gameCount, cars, carsPositions);

        List<String> winners = GetWinners.getWinners(cars, carsPositions);
        printWinners(winners);
    }

    public static void printGameCountInputMessage() {
        System.out.println("시도할 회수는 몇회인가요?");
    }

    public static void printResultMessage() {
        System.out.println("실행 결과");
    }

    public static void printCarsPositions(List<String> cars, List<Integer> carsPositions) {
        for (int i = 0; i < cars.size(); i++) {
            String car = cars.get(i);
            int position = carsPositions.get(i);

            System.out.printf("%s : ", car);

            for (int j = 0; j < position; j++) {
                System.out.print("-");
            }

            System.out.println();
        }

        System.out.println();
    }

    public static List<Integer> printCarsPositionsProgress(int gameCount, List<String> cars, List<Integer> carsPositions) {
        for (int i = 0; i < gameCount; i++) {
            carsPositions = CalculateCarsPositions.calculateCarsProgresses(carsPositions);
            printCarsPositions(cars, carsPositions);
        }

        return carsPositions;
    }

    public static void printWinners(List<String> winners) {
        System.out.print("최종 우승자 : " + String.join(", ", winners));
    }
}
