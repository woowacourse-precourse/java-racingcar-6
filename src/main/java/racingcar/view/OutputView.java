package racingcar.view;

public class OutputView {
    private static final String PRINT_WINNER_MESSAGE = "최종 우승자 : ";

    public void printRaceResult(String carName, String ForwardStick) {
        System.out.println(carName + " : " + ForwardStick);
    }

    public void printRaceWiner(String winer) {
        System.out.println(PRINT_WINNER_MESSAGE + winer);
    }

}
