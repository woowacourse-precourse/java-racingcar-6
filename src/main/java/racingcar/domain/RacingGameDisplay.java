package racingcar.domain;

import java.util.List;

public class RacingGameDisplay {

    private RacingGameDisplay() {
    }

    public static void displayRaceStatus(List<RacingCar> racingCars) {
        for (RacingCar car : racingCars) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(car.getName()).append(" : ");
            for (int i = 0; i < car.getDistance(); i++) {
                stringBuilder.append("-");
            }
            System.out.println(stringBuilder);
        }
        System.out.println();
    }

    public static void showWinners(List<String> racingCars) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("최종 우승자 : ");
        for (String car : racingCars) {
            stringBuilder.append(car).append(", ");
        }
        stringBuilder.delete(stringBuilder.length() - 2, stringBuilder.length());
        System.out.println(stringBuilder);
    }

}
