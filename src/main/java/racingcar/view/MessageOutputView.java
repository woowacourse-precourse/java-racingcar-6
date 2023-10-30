package racingcar.view;

public class MessageOutputView {

    public static void outputRoundResult(String roundResult) {
        System.out.println(roundResult);
    }

    public static void outputRacingWinners(String racingWinners) {
        System.out.printf("최종 우승자 : %s", racingWinners);
    }

}
