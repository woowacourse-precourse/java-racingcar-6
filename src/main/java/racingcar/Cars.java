package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class Cars {
    //속성
    String name;
    int distance;

    public Cars(String name) {
        this.name = name;
        this.distance = 0;
    }

    public String getName() {
        return name;
    }

    public int getDistance() {
        return distance;
    }

    // 0~9 사이 수 중 무작위를 시도횟수만큼 돌리고, 4 이상일 때 전진
    public int move(int tryNum) {
        int moveNum = Randoms.pickNumberInRange(0, 9);
            
        if (moveNum >= 4) {
            this.distance++;
        }
        
        return distance;
    }
}
