package racingcar.View;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class RacingGameOutputView {

    public void gameProcessView(Map<String, List<Integer>> forwardState, int turns) {
        // 4. 경기 진행 과정 출력
        System.out.println("\n실행 결과");
        for(int i = 0; i < turns; i++) {
            for(Map.Entry<String, List<Integer>> entry:forwardState.entrySet() ){
                String name = entry.getKey();
                List<Integer> temp = entry.getValue();
                String t = "-".repeat(temp.get(i));
                System.out.printf("%s : %s\n", name, t);
            }
            System.out.println();
        }
    }

    public void gameWinnerView(Map<String, List<Integer>> forwardState) {
        int max = 0;
        int te = 0;
        List<String> winners = new ArrayList<>();

        for(Map.Entry<String, List<Integer>> entry:forwardState.entrySet()) {
            List<Integer> lt = entry.getValue();
            te = lt.get(lt.size() - 1);
            if (max < te) {        // 최대 값이랑 작거나 같음(
                max = te;
                winners.clear();
                winners.add(entry.getKey());
            }else if(max == te) {
                winners.add(entry.getKey());
            }
        }
        System.out.println("최종 우승자 : " + String.join(", ", winners));
    }
}
