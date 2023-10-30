package racingcar.domain;

import java.util.Arrays;

public class PlayRacing {
    private final RaceSetting RACESETTING = new RaceSetting();
    private final NumberManager NUMBERMANAGER = new NumberManager();

    public boolean judgementGoStop() {
        return NUMBERMANAGER.generateRandomNumber() >= 4;
    }

    public String[] raceResult(String[] carList, String[] scoreList) {
        for (int i = 0; i < carList.length; i++) {
            if (judgementGoStop()) {
                scoreList[i] += "-";
            }
            System.out.println(carList[i] + " : " + scoreList[i]);
        }

        System.out.println();
        return scoreList;
    }

    public void playRace() {
        String[] carList = RACESETTING.regCar();
        int playNumber = RACESETTING.playNumber();
        String[] scoreList = new String[carList.length];
        Arrays.fill(scoreList, "");

        System.out.println();
        System.out.println("실행 결과");
        for (int i = 0; i < playNumber; i++) {
            scoreList = raceResult(carList, scoreList);
        }

        System.out.println(getWinnerList(carList, scoreList));
    }

    public int getMaxScore(String[] scoreList) {
        int maxScore = 0;

        for (String index : scoreList) {
            int score = index.length();
            maxScore = Math.max(maxScore, score);
        }

        return maxScore;
    }

    public void addWinner(StringBuilder winnerList, String car) {
        if (!winnerList.isEmpty()) winnerList.append(", ");
        winnerList.append(car);
    }

    public String getWinnerList(String[] carList, String[] scoreList) {
        StringBuilder winnerList = new StringBuilder();
        int maxScore = getMaxScore(scoreList);

        for (int i = 0; i < scoreList.length; i++) {
            String score = scoreList[i];
            if (score.length() == maxScore) {
                addWinner(winnerList, carList[i]);
            }
        }

        return "최종 우승자 : " + winnerList;
    }
}
