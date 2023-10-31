package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.dto.PerGameCarResultDto;

public class Car {
    private String name;
    private int moveCnt;

    public Car(String name){
        this.name = name;
    }

    public int getRandomNum(){
        return Randoms.pickNumberInRange(0, 9);
    }

    public void moveForward(){
        this.moveCnt += 1;
    }

    public int race(){
        if(getRandomNum()>=4){
            moveForward();
        }
        return moveCnt;
    }

    public PerGameCarResultDto getCarStatus(){
        return new PerGameCarResultDto(name, moveCnt);
    }

    public boolean isWinner(int maxMoveCnt){
        return moveCnt == maxMoveCnt;
    }

    public String getName() {
        return name;
    }
}
