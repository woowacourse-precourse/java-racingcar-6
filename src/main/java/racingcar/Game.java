package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Game {
    private final GameUtil gameUtil = new GameUtil();

    private List<Racer> racerList;

    private final int moveCount;

    public Game(String input, int moveCount) {
        this.racerList = gameUtil.inputToNameList(input)
                .stream()
                .map(Racer::new)
                .toList();
        this.moveCount = moveCount;
    }

    public int getRandomNumber(){
        return Randoms.pickNumberInRange(0, 9);
    }

    public boolean canMove(int randomNumber){
        return randomNumber >= 4;
    }

    public List<Racer> getWinner(){
        int max = getMax();

        return racerList.stream()
                .filter(racer -> racer.getScore().length() == max)
                .toList();
    }

    private Integer getMax() {
        return racerList.stream()
                .map(racer -> racer.getScore().length())
                .max(Integer::compareTo)
                .get();
    }
}
