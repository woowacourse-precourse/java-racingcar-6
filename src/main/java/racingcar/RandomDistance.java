package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class RandomDistance {
    Integer distance = 0;
    List<Integer> answer = new ArrayList<>();

    public Integer getDistance(Integer value){
        int randomDistance = Randoms.pickNumberInRange(0, 9);

        //어레이리스트가 비어있으면 0 입력, 비어있지않으면 해당 인덱스에 맞는 값 불러오기
        if (answer.size() > 0){
            distance = answer.get(value);
        } else{
            answer.add(value, 0);
        }
        //랜덤 거리가 4이상이면 기존 거리에 1 더하기
        if (randomDistance >= 4) {
            distance += 1;
        }
        answer.add(value, distance);
        return answer.get(value);
    }
}
