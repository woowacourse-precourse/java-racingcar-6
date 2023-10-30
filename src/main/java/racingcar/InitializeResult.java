package racingcar;

import java.util.List;

public class InitializeResult {

    public void initialize(int i , List<Integer> result){
        for (int j = 0 ; j < i; j++) {
            result.add(j,0);
        }
    }

}
