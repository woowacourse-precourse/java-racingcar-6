package racingcar;

import java.util.List;
import java.util.Map;

public class RacingCarGameImpl implements RacingCarGame {

    @Override
    public void startGame() {
        InputImpl input = new InputImpl();
        
        List<String> carNames = input.carName();
        int attemtsNumber = input.attemptsNumber();
        
        GameItemImpl gameItem = new GameItemImpl(carNames);
        Map<String, Integer> positions = gameItem.carPostion();
        
        PrintImpl print = new PrintImpl(carNames, positions);
        print.printCarPositions();
    }

}
