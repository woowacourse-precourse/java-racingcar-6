package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class Judgement {
    public List<Boolean> correctCount(List<Integer> computer){
        List<Boolean> tf = new ArrayList<>();
        for(int i = 0; i < computer.size(); i++){
            if(computer.get(i) >= 4){
                tf.add(true);
                continue;
            }
            tf.add(false);
        }
        return tf;
    }
}
