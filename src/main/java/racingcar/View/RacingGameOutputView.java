package racingcar.View;

import java.util.List;
import java.util.Map;

public class RacingGameOutputView {

    public void gameProcessView(Map<String, List<Integer>> forwardState, int turns) {
        // 4. 경기 진행 과정 출력
        System.out.println("\n실행 결과");
        for(int i = 1; i <= turns; i++) {
            for(Map.Entry<String, List<Integer>> entry:forwardState.entrySet() ){
                String name = entry.getKey();
                List<Integer> temp = entry.getValue();
                String t = "-".repeat(temp.get(i));
                System.out.printf("%s : %s\n", name, t);
            }
            System.out.println();
        }
    }

    public void gameWinnerView(List<String> winners) {
        System.out.println("최종 우승자 : " + String.join(", ", winners));
    }
}
