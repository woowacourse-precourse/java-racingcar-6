package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class Game {
    private final GameUtil gameUtil = new GameUtil();

    private List<Racer> racerList;

    private final int moveCount;

    public Game() {
        this.racerList = gameUtil.inputToNameList(gameUtil.getCarName())
                .stream()
                .map(Racer::new)
                .toList();
        this.moveCount = gameUtil.getMoveCount();
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

    public void gameStart(){
        System.out.println("실행 결과");
        for (int i = 0; i < moveCount; i++) {
            proceedOneRound();
        }
        gameUtil.printWinner(getWinner());
    }

    public void proceedOneRound(){
        for(Racer racer : racerList){
            if(canMove(getRandomNumber())){
                racer.move();
            }
        }
        gameUtil.printEachResult(racerList);
    }
}
