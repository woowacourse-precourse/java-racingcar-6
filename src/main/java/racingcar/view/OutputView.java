package racingcar.view;

import racingcar.domain.RacingCar;

import java.util.List;

public class OutputView {
    public void printRacingCarInputMessage() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    public void printTryCountInputMessage() {
        System.out.println("시도할 회수는 몇회인가요?");
    }

    public void printResult() {
        System.out.println("\n실행 결과");
    }

    public void printAllRacingCarsPosition(List<RacingCar> racingCars) {
        for (RacingCar racingCar : racingCars) {
            printRacingCarPosition(racingCar);
        }
        System.out.println();
    }

    private void printRacingCarPosition(RacingCar raceCar) {
        System.out.print(raceCar.getName() + " : ");
        for (int i = 0; i < raceCar.getPosition(); i++) {
            System.out.print("-");
        }
        System.out.println();
    }

    public void printWinners(List<RacingCar> winners) {
        System.out.println("최종 우승자 : " + getWinnerNames(winners));
    }

    private String getWinnerNames(List<RacingCar> winners) {
        StringBuilder carNames = new StringBuilder();

        for (int i = 0; i < winners.size(); i++) {
            carNames.append(winners.get(i).getName());
            if (i < winners.size() - 1) {
                carNames.append(", ");
            }
        }

        return carNames.toString();
    }
}
