package racingcar;

import java.util.List;
import java.util.Collections;
import java.util.stream.Collectors;
import camp.nextstep.edu.missionutils.Console;

public class RacingGame {

    public static final int NAME_MAX_LEN = 5;
    public static final int MOVE_FORWARD_COND = 4;
    public static final int RANDOM_NUM_MIN_RANGE = 0;
    public static final int RANDOM_NUM_MAX_RANGE = 9;

    public void start(){
        guideUserInsertRacingCarName();
        String[] nameAry = Utils.inputNameSplit(",", Utils.userInput());
        List<String> nameList = Utils.inputStrAryToNameList(nameAry);
        Utils.nameIsValid(nameList, NAME_MAX_LEN);
        List<Player> players = Utils.nameListToPlayerList(nameList);

        guideUserInsertRacingTryCount();
        final int tryCount = Utils.inputTryCount();
        guideUserRacingResult();
        for(int i=0; i<tryCount; i++){
            players.stream()
                    .forEach(player -> {player.move(); player.print();});
            System.out.println();
        }

        printWinner(chooseWinner(players));
        exit();
    }

    public void guideUserInsertRacingCarName(){
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }
    public void guideUserInsertRacingTryCount(){
        System.out.println("시도할 회수는 몇회인가요?");
    }
    public void guideUserRacingResult(){
        System.out.println("실행결과");
    }

    public void printWinner(List<Player> winners){
        String winnerString = winners.stream().map(Player::getName).collect(Collectors.joining(", "));
        System.out.printf("최종 우승자 : %s\n", winnerString);
    }
    public List<Player> chooseWinner(List<Player> players){
        Collections.sort(players, Collections.reverseOrder());
        final int bestScore = players.get(0).step;
        return players.stream()
                .filter(player -> player.step == bestScore)
                .collect(Collectors.toList());
    }

    public void exit(){
        Console.close();
    }

}
