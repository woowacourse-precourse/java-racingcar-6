package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;
public class RacingCarGameManager {
    private static int round;
    
    public RacingCarGameManager(int round, List<String> carNames) {
        this.round = round;
        CarInfoManager.initializeCarInfos(carNames);
    }

    public static void start() {
        System.out.println("\n실행 결과");
        repeatRoundTimes();
        printFinalResult();
        endGame();
    }

    private static void repeatRoundTimes() {
        for (int i = 0; i < round; i++) {
            CarInfoManager.carInfos.forEach(
                    car -> updatePosition(car)
            );
            printResult();
        }
    }

    private static void updatePosition(Car car) {
        int randomNumber = Randoms.pickNumberInRange(0, 9);
        if (randomNumber >= 4) {
            car.move();
        }
    }
    private static void printResult() {
        CarInfoManager.carInfos.forEach(
                car -> car.printCurrentPosition()
        );
        System.out.println();
    }

    private static void printFinalResult() {
        System.out.println("최종 우승자 : " + getWinner());
    }

    private static String getWinner() {
        int maxPosition = CarInfoManager.carInfos.stream()
                .mapToInt(car -> car.getPosition())
                .max()
                .orElse(0);

        StringBuilder winner = new StringBuilder();
        CarInfoManager.carInfos.forEach(
                (car) -> {
                    if (car.getPosition() == maxPosition) {
                        winner.append(car.getName()).append(", ");
                    }
                }
        );

        return winner.substring(0, winner.length() - 2);
    }

    public static void endGame() {
        CarInfoManager.close();
    }
}
