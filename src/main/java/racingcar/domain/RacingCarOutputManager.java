package racingcar.domain;

public class RacingCarOutputManager {

    public void println(String text) {
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

        println(String.format("%s : %s", carName, positionText));
    }
}
