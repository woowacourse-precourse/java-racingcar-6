package racingcar.game;

import camp.nextstep.edu.missionutils.Console;
import racingcar.car.Track;
import racingcar.util.InputUtil;

public class GameService {
    private static final GameService instance = new GameService();

    private static final Track tracks = Track.getInstance();

    private GameService() {

    }

    public static GameService getInstance() {
        return instance;
    }

    public void runRace() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String str = Console.readLine();
        tracks.setCars(InputUtil.inputNames(str));

        System.out.println("시도할 회수는 몇회인가요?");
        int count = Integer.parseInt(Console.readLine());

        System.out.println("\n실행 결과");

        for (int i = 0; i < count; i++) {
            tracks.runCars();
            tracks.printCars();
        }

        tracks.print1st();
    }


}
