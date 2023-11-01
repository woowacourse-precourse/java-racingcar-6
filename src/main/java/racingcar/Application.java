package racingcar;

import java.util.ArrayList;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        ArrayList<RacingCar> racingCars = new ArrayList<>();

        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");

        String[] racingCarNames = readLine().split(",");
        for (String racingCarName : racingCarNames) {
            if (5 < racingCarName.length()) {
                throw new IllegalArgumentException();
            }
            racingCars.add(new RacingCar(racingCarName));
        }

        System.out.println("시도할 회수는 몇회인가요?");
        int numberofRepeat;
        try {
            numberofRepeat = Integer.valueOf(readLine());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }

        System.out.println("실행 결과");
        for (int i = 0; i < numberofRepeat; i++) {
            for (RacingCar car : racingCars) {
                car.move(car.rollDice());
                System.out.println(car.name + " : " + car.showMoveCount());
            }
            System.out.println();
        }

        int maxCount = 0;
        ArrayList<RacingCar> winner = new ArrayList<>();
        for (RacingCar car : racingCars) {
            maxCount = Math.max(maxCount, car.showMoveCount());
        }
        for (RacingCar car : racingCars) {
            if (maxCount == car.showMoveCount()) {
                winner.add(car);
            }
        }
        System.out.print("최종 우승자 :");
        StringBuilder winners = new StringBuilder();
        for (RacingCar car : winner) {
            winners.append(" ").append(car.name).append(",");
        }
        winners.deleteCharAt(winners.length()-1);
        System.out.println(winners);
    }
}
