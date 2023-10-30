package racingcar.model;


import static camp.nextstep.edu.missionutils.Console.readLine;

import java.util.List;

public class Game implements Rule{
    /**
     * @return 쉼표로 구분된 자동차 이름을 분할한 리스트
     */
    @Override
    public List<String> getCarNames() {
        return List.of(readLine().split(","));
    }

    /**
     * @return
     */
    @Override
    public Integer getNumberOfRounds() {
        return null;
    }

    /**
     *
     */
    @Override
    public void printCurrentPerformance() {

    }

    /**
     *
     */
    @Override
    public void printBestPerformers() {

    }
}
