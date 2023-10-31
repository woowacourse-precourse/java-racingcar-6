package racingcar;

public class Race {
    public static final String GAME_START = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    public static final String INPUT_COUNT = "시도할 회수는 몇회인가요?";
    public static final String GAME_RESULT = "실행 결과";
    public static final String GAME_OVER = "최종 우승자 : ";
    private int count;
    private Track track;

    public Race() {
        track = new Track();
    }
    public void start() {
        ready();
        set();
        go();
        finish();
    }

    private void ready() {
        Output.printMessage(GAME_START);
        track.addCars(Input.readCars());
    }

    private void set() {
        Output.printMessage(INPUT_COUNT);
        count = Input.readCount();
    }

    private void go() {
        Output.printMessage(GAME_RESULT);
        while(count != 0) {
            track.moveCars();
            Output.printMessage(track.showProgress());
            count--;
        }
    }

    private void finish() {
        Output.printMessage(GAME_OVER + track.showResult());
    }


}
