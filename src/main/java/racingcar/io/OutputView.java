package racingcar.io;

public class OutputView {
    public void print(String text) {
        System.out.println(text);
    }

    public void printEnter() {
        System.out.println();
    }

    public void printCarPosition(String carName, int position) {
        StringBuilder positionText = new StringBuilder();
        for (int i = 0; i < position; i++) {
            positionText.append("-");
        }

        print(String.format("%s : %s", carName, positionText));
    }
}
