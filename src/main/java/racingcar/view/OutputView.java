package racingcar.view;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class OutputView {

    public void initial() {
        System.out.println("\n실행 결과");
    }
    public void result(HashMap distance) {
        Set<Map.Entry<String, String>> result = distance.entrySet();
        for(Map.Entry<String, String> movement : result){
            System.out.println(movement.getKey() + " : " + movement.getValue());
        }
        System.out.println();
    }
}
