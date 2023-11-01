package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.LinkedHashMap;
import java.util.List;

public class RunningGame implements Running { //게임을 진행합니다.
    private static IO io;
    private static Sorting sorting;
    private List<String> RunnerMap;//자동차의 이름을 나타냄
    private LinkedHashMap<String, String> GameInfoMap; //각 자동차의 이름과 경주상태를 나타냄

    public RunningGame(IO io, Sorting sorting, Setting setting) {
        this.io = io;
        this.sorting = sorting;
        this.RunnerMap = setting.getRunnerMap();
        this.GameInfoMap = setting.getGameInfoMap();
    }

    @Override
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

    private void run() { // 게임 진행
        for (String key : RunnerMap) {
            updateGameInfo(key);
        }
    }

    private void updateGameInfo(String key) {
        String value = GameInfoMap.get(key);
        int random = Randoms.pickNumberInRange(0, 9);
        if (random >= 4) {
            GameInfoMap.put(key, value + "-");
        }
    }

    @Override
    public void createResult(){
        RunnerMap.clear();
        RunnerMap = sorting.Winner(GameInfoMap);
        io.printWinners(RunnerMap);
    }
}
