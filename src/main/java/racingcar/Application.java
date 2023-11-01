package racingcar;

public class Application {
    public static void main(String[] args) {
        View view = new View();
        String racingCarNames = view.racingCarNamesInput();
        int racingFrequencyNum = view.racingFrequencyInput();
        RacingPlay racingPlay = new RacingPlay(racingCarNames, racingFrequencyNum);
        for(int i = 0; i < racingFrequencyNum; i++){
            racingPlay.oneTryRacing();
            racingPlay.viewCurrentRacingResult();
        }
        racingPlay.viewRacingWinner();
    }
}
