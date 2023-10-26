package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class RacingCar {
    private String name;
    private Integer move;
    public RacingCar(String name, Integer move){
        this.name = name;
        this.move = move;
    }

    public String getName() {
        return name;
    }

    /** True 이동o , False면 이동x  */
    public boolean randomNumber(){
        int randomNumber = Randoms.pickNumberInRange(0,9);
        if(randomNumber >=4){
            return true;
        }
        return false;

    }
}
