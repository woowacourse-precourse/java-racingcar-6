package racingcar;

import java.util.List;
import java.util.Map;

/**
 * 출력을 담당하는 클래스
 * 
 * @author 김지환
 */
public class OutputImpl implements Output {
    private List<String> carNames;
    private Map<String, Integer> carPositions;
    
    public OutputImpl(List<String> input, Map<String, Integer> carPosition) {
        this.carNames = input;
        this.carPositions = carPosition;
    }
    
    @Override
    public void winner(List<String> winners) {
        String winnerNames = String.join(", ", winners);
        System.out.println("최종 우승자 : " + winnerNames);
    }

    @Override
    public void printCarLocations() {
        for (String name : carNames) {
            printCarLocation(name, carPositions.get(name));
        }
        System.out.println();
        
    }
    
    private void printCarLocation(String name, int position) {
        System.out.print(name + " : ");
        for (int i = 0; i < position; i++) {
            System.out.print("-");
        }
        System.out.println();
    }

}
