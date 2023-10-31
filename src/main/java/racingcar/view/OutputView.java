package racingcar.view;

public class OutputView {
    private static final String WINNERS_MESSAGE = "최종 우승자 : ";
    public static void printResultOfRace(String carName, int distance) {
        System.out.print(carName + " : ");
        String raceState = "-".repeat(distance);
        System.out.println(raceState);
    }

    public void printWinners() {

    }
}
