package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class Judgement {
    public List<Boolean> correctCount(List<Integer> computer){
        // 3개의 판별여부가 담길 때까지 반복한다.
        // 4이상의 값일 때만 true를 저장한다.
        // 조건에 부합하지 않을 경우 false를 저장한다.
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
