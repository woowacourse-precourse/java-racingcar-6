package racingcar.view;

public class OutputView {

    public void printTrialResult(String name, int position) {
        System.out.print(name + " : ");
        for (int i = 0; i < position; i++) {
            System.out.print("-");
        }
        System.out.println();
    }

    public void printWinnerCars(String name) {
        System.out.print("최종 우승자 : " + name);
    }
}
