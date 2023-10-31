package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.LinkedHashMap;
import java.util.List;

public class RunningGame { //게임을 진행합니다.
    private static IO io;
    private static Sorting sorting;
    private List<String> RunnerMap;//자동차의 이름을 나타냄
    private LinkedHashMap<String, String> GameInfoMap; //각 자동차의 이름과 경주상태를 나타냄

    public RunningGame(IO io, Sorting sorting, SettingGame settinggame) {
        this.io = io;
        this.sorting = sorting;
        this.RunnerMap = settinggame.getRunnerMap();
        this.GameInfoMap = settinggame.getGameInfoMap();
    }

    public void runGame() {
        int count = count();
        while (count != 0) {
            run();
            io.printRunResult(GameInfoMap);
            io.printNull();
            count--;
        }
    }

    private int count() {
        int count = Integer.parseInt(io.count());
        return count;
    }

    private void run() { //게임 진행

        for (String key : RunnerMap) {
            String value = GameInfoMap.get(key);

            int random = Randoms.pickNumberInRange(0, 9);
            if (random >= 4) {
                GameInfoMap.put(key, value + "-");
            }
        }

    }

    public void createResult(){
        RunnerMap.clear();
        RunnerMap = sorting.Winner(GameInfoMap);
        io.printWinners(RunnerMap);
    }
}
