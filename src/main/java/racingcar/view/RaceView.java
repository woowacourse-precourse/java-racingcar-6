package racingcar.view;

import racingcar.model.Car;

import java.util.List;

public class RaceView {
    private final String finalWinner = "최종 우승자 : ";
    private StringBuilder sb;
    private int carScore;
    private String carName;

    public void displayRaceResults(List<Car> cars) {
        sb = new StringBuilder();
        for (Car car : cars) {
            carName = car.getCarName();
            carScore = car.getCarScore();

            sb.append(carName).append(" : ");
            carScoreToBar(carScore);
        }
        System.out.println(sb);
    }

    public void carScoreToBar(int carScore) {
        sb.append("-".repeat(Math.max(0, carScore))).append("\n");
    }

    public void displayWinner(List<String> raceWinner) {
        sb = new StringBuilder();
        String winners = String.join(", ", raceWinner);
        sb.append(finalWinner).append(winners);
        System.out.print(sb);
    }


}
