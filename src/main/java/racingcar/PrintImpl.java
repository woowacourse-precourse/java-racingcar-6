package racingcar;

import java.util.List;
import java.util.Map;

public class PrintImpl implements Print {
    private List<String> carNames;
    private Map<String, Integer> carPositions;
    
    public PrintImpl(List<String> input, Map<String, Integer> carPosition) {
        this.carNames = input;
        this.carPositions = carPosition;
    }
    
    @Override
    public void winner() {
        // TODO Auto-generated method stub

    }

    @Override
    public void printCarPositions() {
        for (String name : carNames) {
            int currentPosition = carPositions.get(name);
            System.out.print(name + " : ");
            for (int i = 0; i < currentPosition; i++) {
                System.out.print("-");
            }
            System.out.println();
        }
        System.out.println();
        
    }

}
