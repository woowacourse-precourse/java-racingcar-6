package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class PlayRacing {
    private final RaceSetting RACESETTING = new RaceSetting();
    private final NumberManager NUMBERMANAGER = new NumberManager();

    public boolean judgementGoStop() {
        return NUMBERMANAGER.generateRandomNumber() >= 4;
    }

    public String raceResult(int playNumber) {
        StringBuilder score = new StringBuilder();
        for (int i = 0; i < playNumber; i++) {
            if (judgementGoStop()) score.append("-");
        }
        return score.toString();
    }

    public void playRace() {
        List<String> carList = RACESETTING.regCar();
        int playNumber = RACESETTING.playNumber();
        List<String> scoreList = new ArrayList<>();

        for (int i = 0; i < carList.size(); i++) {
            String score = raceResult(playNumber);
            scoreList.add(score);
        }

        for (int j = 0; j < carList.size(); j++) {
            System.out.println(carList.get(j) + " : " + scoreList.get(j));
        }

    }

    public void winnerList(List<String> scoreList) {

    }
}
