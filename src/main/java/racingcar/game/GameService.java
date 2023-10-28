package racingcar.game;

import camp.nextstep.edu.missionutils.Console;
import racingcar.car.Track;
import racingcar.util.InputUtil;

public class GameService {
    private static final GameService instance = new GameService();

    private static final Track tracks = Track.getInstance();

    private GameService(){

    }

    public static GameService getInstance(){
        return instance;
    }

    public void runRace(){
        String str = Console.readLine();
        tracks.setCars(InputUtil.inputNames(str));
        tracks.printCars();
    }


}
