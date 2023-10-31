package racingcar;

import java.util.Map;

public class Grandprix {
    SystemOutput systemOutput = new SystemOutput();

    private int numberOfTrials;     //테스트에서 사용할 변수
    private int numberOfCars;       //테스트에서 사용할 변수

    //게임 회수와 String/Car MAP을 받아서 게임 진행
    public Map<String, Car> playGrandprix(int numberOfTry, Map<String, Car> racingPlayer) {
        System.out.println("실행 결과");
        for (int i = 0; i < numberOfTry; i++) {
            for (String player : racingPlayer.keySet()) {
                racingPlayer.get(player).goOrStop(0, 9);
                systemOutput.showStatus(player, racingPlayer.get(player).getLocation());
            }
            numberOfTrials = i + 1;
            System.out.println();
        }
        numberOfCars = racingPlayer.size();
        return racingPlayer;
    }


    //이하: 테스트를 위한 getter

    public int getNumberOfTrials() {
        return numberOfTrials;
    }

    public int getNumberOfCars() {
        return numberOfCars;
    }
}