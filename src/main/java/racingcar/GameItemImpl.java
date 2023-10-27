package racingcar;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import camp.nextstep.edu.missionutils.Randoms;

public class GameItemImpl implements GameItem {
    private List<String> carNames;
    private Map<String, Integer> carPositions;
    
    public GameItemImpl(List<String> input) {
        this.carNames = input;
        this.carPositions = new HashMap<>();
        for (String name : carNames) {
            carPositions.put(name, 0);
        }
    }
    
    @Override
    public void carMove(int attemptsNumber, PrintImpl print) {
        for (int i = 0; i < attemptsNumber; i++) {
            moveCars();
            print.printCarPositions();
        }
    }
    
    private void moveCars() {
        for (String name : carNames) {
            int randomNum = Randoms.pickNumberInRange(0, 9);
            if (randomNum >= 4) {
                int currentPosition = carPositions.get(name);
                carPositions.put(name, currentPosition + 1);
            }
        }
    }

    @Override
    public List<String> checkWinner() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Map<String, Integer> carPosition() {
        return carPositions;
    }


}
