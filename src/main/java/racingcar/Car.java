package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    private String name;
    private int distance=0;

    int drive_random(){
        if(Randoms.pickNumberInRange(0,9)>=4){
            distance+=1;
        };
        return distance;
    }
}
