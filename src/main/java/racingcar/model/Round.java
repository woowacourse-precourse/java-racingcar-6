package racingcar.model;

public class Round {
    private int totalRound;
    private int nowRound;

    public Round(String inputString) {
        // inputString에 대한 검사
        totalRound = Integer.parseInt(inputString);
        nowRound = 0;
    }

}
