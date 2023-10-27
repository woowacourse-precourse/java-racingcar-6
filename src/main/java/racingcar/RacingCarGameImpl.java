package racingcar;

import java.util.List;
import java.util.Map;

public class RacingCarGameImpl implements RacingCarGame {

    @Override
    public void startGame() {
        InputImpl input = new InputImpl();
        
        List<String> carNames = input.carName();
        int attemptsNumber = input.attemptsNumber();
        
        GameItemImpl gameItem = new GameItemImpl(carNames);
        Map<String, Integer> positions = gameItem.carPosition();
        PrintImpl print = new PrintImpl(carNames, positions);
        System.out.println("실행 결과");
        gameItem.carMove(attemptsNumber, print);
        print.winner(gameItem.checkWinner());
        
        
    }

}
