package racingcar;

import java.util.List;
public class RacingDefine {

    public RacingDefine() {
    }

    public static List<String> DefineDistance(List<Integer> cnum, List<String> distance) {

        String nowDistance = "";

        for(int i = 0; i < cnum.size(); i++) {
            nowDistance = distance.get(i);
            if(cnum.get(i) < 5) {
                nowDistance = distance.get(i);
                nowDistance = nowDistance.concat("-");
                distance.set(i, nowDistance);
            }
        }

        return distance;
    }
}