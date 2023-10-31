package racingcar.view;

public class OutputView {
    public void printRacingResult(String carName, int carPosition) {
        System.out.print(carName + " : ");
        for (int i = 0; i < carPosition; i++) {
            System.out.print("-");
        }
        System.out.println();
    }

    public void printWinnerCars(String name) {
        System.out.print("최종 우승자 : " + name);
    }
}
