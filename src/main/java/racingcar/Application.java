package racingcar;

public class Application {

    public static void main(String[] args) {

        InputRacingInfo inputRacingInfo = new InputRacingInfo();
        RacingInfo racingInfo = inputRacingInfo.createRacingInfo();

        RepeatRacing repeatRacing = new RepeatRacing();
        repeatRacing.startRacing(racingInfo);
    }
}
