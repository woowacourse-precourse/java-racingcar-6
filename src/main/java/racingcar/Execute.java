package racingcar;

import racingcar.model.Car;

import java.util.ArrayList;
import java.util.List;

import static racingcar.console.Input.inputCarName;
import static racingcar.console.Input.inputRaceTime;
import static racingcar.console.OutPut.printWinner;
import static racingcar.racingGame.Racing.playGame;

public class Execute {
    public static Long raceTime;
    public static String[] carNames;
    // 자동차 마다 현 위치를 저장하기 위해 map을 활용하였습니다. racTime 이 Long 이기 때문에 value type 은 Long 입니다.
    public static List<Car> carRace = new ArrayList<>();
    public static Long maxDistance = 0L;
    public static void startGame(){

        inputCarName();
        inputRaceTime();
        playGame();
        printWinner();
    }
}

