package racingcar.view;

public class OutputView {

    public static String resultText(){
        return UITexts.RACING_RESULT.getText();
    }

    public static String showMoveStatus(int position) {
        StringBuilder positionIndicator = new StringBuilder();
        for (int i = 0; i < position; i++) {
           positionIndicator.append("-");
        }
        return positionIndicator.toString();
    }

}
