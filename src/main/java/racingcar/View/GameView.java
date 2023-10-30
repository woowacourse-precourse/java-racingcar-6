package racingcar.View;

public class GameView {

    private final String MOVE_SYMBOL = "-";
    private final String NAME_LOCATION_SPLITTER = " : ";
    private final String RESULT_NOTICE_MSG = "실행결과";

    public void printCarLocation(String carName, int carLocationInt) {
        String carLocationView = generateLocationView(carLocationInt);
        System.out.println(carName + NAME_LOCATION_SPLITTER + carLocationView);
    }

    public String generateLocationView(int carLocationInt) {
        String carLocationView = "";
        for (int i = 0; i < carLocationInt; i++) {
            carLocationView += MOVE_SYMBOL;
        }
        return carLocationView;
    }

    public void printResultNoticeMsg() {
        System.out.println(RESULT_NOTICE_MSG);
    }
}
