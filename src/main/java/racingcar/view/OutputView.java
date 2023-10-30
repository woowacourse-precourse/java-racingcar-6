package racingcar.view;

public class OutputView {
    public void outputCarMoveDistance(String carName, int stepDistance) {
        System.out.print(carName + " : ");
        for (int i = 0; i < stepDistance; i++) {
            System.out.print("-");
        }
    }
}
