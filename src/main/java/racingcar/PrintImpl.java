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
    public void winner(List<String> winners) {
        String winnerNames = String.join(", ", winners);
        System.out.println("최종 우승자 : " + winnerNames);
    }

    @Override
    public void printCarPositions() {
        for (String name : carNames) {
            printCarPosition(name, carPositions.get(name));
        }
        System.out.println();
        
    }
    
    private void printCarPosition(String name, int position) {
        System.out.print(name + " : ");
        for (int i = 0; i < position; i++) {
            System.out.print("-");
        }
        System.out.println();
    }

}
