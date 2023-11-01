package racingcar;

import java.util.List;
import java.util.Map;

/**
 * 게임 시작을 위한 클래스
 * 
 * @author 김지환
 */
public class RacingCarGameImpl implements RacingCarGame {

    @Override
    public void startGame() {
        InputImpl input = new InputImpl();
        
        List<String> carNames = input.carName();
        int attemptsNumber = input.attemptsNumber();
        
        GameItemImpl gameItem = new GameItemImpl(carNames);
        Map<String, Integer> positions = gameItem.carPosition();
        
        OutputImpl output = new OutputImpl(carNames, positions);
        System.out.println("실행 결과");
        gameItem.carMove(attemptsNumber, output);
        output.winner(gameItem.checkWinner());
        
    }

}
