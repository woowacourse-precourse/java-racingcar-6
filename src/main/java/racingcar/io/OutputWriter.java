package racingcar.io;

public class OutputWriter implements Writer {

    @Override
    public void write(String msg) {
        System.out.println(msg);
    }

//    public void writeInputNameMsg() {
//        System.out.println(INPUT_CAR_NAMES);
//    }
//
//    public void writeInputTryTimesMsg() {
//        System.out.println(INPUT_TRY_TIMES);
//    }
//
//    public void writeGameResultMsg() {
//        System.out.println(GAME_RESULT);
//    }
//
//    public void writeGameWinnerMsg() {
//        System.out.print(WINNER_RESULT);
//    }
}
