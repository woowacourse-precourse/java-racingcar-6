package racingcar.view;

import java.util.List;
import racingcar.model.RacingCar;
import racingcar.model.RacingCars;

public class OutputView {

    public void printAskingForCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    public void printAskingForNumberOfRounds() {
        System.out.println("시도할 회수는 몇회인가요?");
    }

    public void printResult() {
        System.out.println("실행 결과");
    }

    public void printCarsLocation(RacingCars racingCars) {
        for (RacingCar racingCar : racingCars.racingCarList()) {
            printCarCurrentLocation(racingCar);
        }
        System.out.println();
    }

    private void printCarCurrentLocation(RacingCar racingCar) {
        String carName = racingCar.getName();
        int currentLocationValue = racingCar.getLocation();
        System.out.println(carName + " : " + "-".repeat(currentLocationValue));
    }

    public void printWinners(RacingCars winners) {
        List<RacingCar> winnersCarList = winners.racingCarList();
        System.out.print("최종 우승자 : ");
        for (int i = 0; i < winnersCarList.size(); i++) {
            RacingCar racingCar = winnersCarList.get(i);
            System.out.print(racingCar.getName());
            printCommaBetweenWinners(i, winnersCarList);
        }
    }

    private void printCommaBetweenWinners(int winnerIndex, List<RacingCar> winnersCarList) {
        if (isCommaNeededBetweenWinners(winnerIndex, winnersCarList)) {
            System.out.print(", ");
        }
    }

    private boolean isCommaNeededBetweenWinners(int i, List<RacingCar> winnersCarList) {
        return i < winnersCarList.size() - 1;
    }
}
