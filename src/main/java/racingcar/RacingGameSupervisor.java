package racingcar;

import java.util.ArrayList;
import java.util.List;

public class RacingGameSupervisor {
    private RacingGameManager racingGameManager;
    private List<RacingCar> winnerList;

    public RacingGameSupervisor(RacingGameManager racingGameManager) {
        this.racingGameManager = racingGameManager;
        this.winnerList = new ArrayList<>();
    }

    public String decideWinner() {
        int winnerPosition = findMaxPosition();
        List<RacingCar> raceResult = racedCarList();

        for (RacingCar cars : raceResult) {
            if (cars.getCurrentPosition() == winnerPosition) {
                winnerList.add(cars);
            }
        }

        return formatWinnerList();
    }

    private String formatWinnerList() {
        String[] winners = winnerList();
        return String.join(", ", winners);
    }

    private String[] winnerList() {
        return winnerList.stream()
                .map(RacingCar::getCarName)
                .toArray(String[]::new);
    }

    private int findMaxPosition() {
        List<RacingCar> raceResult = racedCarList();
        int max = 0;

        for(RacingCar cars : raceResult) {
            if(cars.getCurrentPosition() > max){
                max = cars.getCurrentPosition();
            }
        }
        return max;
    }

    private List<RacingCar> racedCarList() {
        return racingGameManager.raceCars();
    }
}
