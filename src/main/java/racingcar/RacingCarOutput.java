package racingcar;

import java.util.List;

public class RacingCarOutput {
    public void printCarNameInput() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    public void printUserInput() {
        System.out.println("시도할 회수는 몇회인가요?");
    }

    public void printResult() {
        System.out.println("실행 결과");
    }

    public void printStep(RacingCars racingCars) {
        List<RacingCar> racingCarList = racingCars.getRacingCars();
        for (RacingCar car : racingCarList) {
            System.out.print(car.getName() + " : ");
            for (int i = 0; i < car.getDistance(); i++) {
                System.out.print('-');
            }
            System.out.println();
        }
        System.out.println();
    }

    public void printWinner(List<RacingCar> carsWithMaxDistance) {
        StringBuilder winners = new StringBuilder("최종 우승자 : ");
        for (int i = 0; i < carsWithMaxDistance.size(); i++) {
            if (i > 0) {
                winners.append(", ");
            }
            winners.append(carsWithMaxDistance.get(i).getName());
        }
        System.out.println(winners);
    }
}
