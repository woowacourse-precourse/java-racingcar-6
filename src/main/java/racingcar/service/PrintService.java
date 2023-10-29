package racingcar.service;

import racingcar.domain.RacingCar;

import java.util.List;

public class PrintService {
    public static void printRacingCarInputForm() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    public static void printTimesInputForm() {
        System.out.println("시도할 회수는 몇회인가요?");
    }

    public static void printGameOutcomeMessage() {
        System.out.println("\n실행 결과");
    }

    public static void printOneGameOutcome(List<RacingCar> racingCars) {
        for (RacingCar racingCar : racingCars) {
            System.out.printf("%s : ", racingCar.getName());
            for (int i = 0; i < racingCar.getLocation(); i++)
                System.out.print("-");
        }
    }

    public static void printFinalWinner(List<RacingCar> winners) {
        String[] winnerNames = new String[winners.size()];

        for (int i = 0; i < winnerNames.length; i++)
            winnerNames[i] = winners.get(i).getName();

        System.out.printf("최종 우승자 : %s", String.join(", ", winnerNames));
    }
}
