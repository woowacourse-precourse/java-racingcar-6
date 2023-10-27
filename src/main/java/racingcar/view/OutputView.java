package racingcar.view;

import racingcar.domain.Cars;
import racingcar.domain.Winner;

import java.util.List;

public class OutputView {

    private static final String MOVE = "-";
    private static final String DELIMITER = ", ";

    public void printInputCarsName() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    public void printInputTryNumber() {
        System.out.println("시도할 회수는 몇회인가요?");
    }

    public void printResultStart() {
        System.out.println();
        System.out.println("실행 결과");
    }

    public void printResult(Cars cars) {
        List<String> nameOfCars = cars.getCarsName();
        List<Integer> carsCurrentLocation = cars.getCarsCurrentLocation();

        for (int i = 0; i < nameOfCars.size(); i++) {
            String participant = nameOfCars.get(i);
            int carCurrentLocation = carsCurrentLocation.get(i);

            System.out.print(participant + " : ");
            for (int j = 0; j < carCurrentLocation; j++)
                System.out.print(MOVE);
            System.out.println();
        }
        System.out.println();
    }

    public void printWinner(Winner winner) {
        System.out.print("최종 우승자 : " + String.join(DELIMITER, winner.getWinnerName()));
    }
}
