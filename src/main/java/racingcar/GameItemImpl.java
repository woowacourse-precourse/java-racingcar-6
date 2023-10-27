package racingcar;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import camp.nextstep.edu.missionutils.Randoms;

public class GameItemImpl implements GameItem {
    private List<String> carNames;
    private Map<String, Integer> carPositions;
    
    public GameItemImpl(List<String> carNames) {
        this.carNames = carNames;
        this.carPositions = new HashMap<>();
        setCarPosition();
    }
    
    private void setCarPosition() {
        for (String name : carNames) {
            carPositions.put(name, 0);
        }
    }
    
    @Override
    public void carMove(int attemptsNumber, OutputImpl output) {
        for (int i = 0; i < attemptsNumber; i++) {
            moveCars();
            output.printCarLocations();
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
        int maxPosition = getMaxPosition();
        List<String> winners = getWinners(maxPosition);
        return winners;
    }

    private int getMaxPosition() {
        int maxPosition = 0;
        for (int position : carPositions.values()) {
            maxPosition = Math.max(maxPosition, position);
        }
        return maxPosition;
    }

    private List<String> getWinners(int maxPosition) {
        List<String> winners = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : carPositions.entrySet()) {
            if (entry.getValue() == maxPosition) {
                winners.add(entry.getKey());
            }
        }
        return winners;
    }
    
    @Override
    public Map<String, Integer> carPosition() {
        return carPositions;
    }


}
