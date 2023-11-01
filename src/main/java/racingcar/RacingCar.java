package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class RacingCar implements Comparable<RacingCar>{
    private int advanceCount;
    private final String name;

    RacingCar(String name){
        this.name = name;
        this.advanceCount = 0;
    }
    public int getAdvanceCount(){
        return this.advanceCount;
    }

    public String getName(){
        return this.name;
    }
    public void playRound(){
        int randomValue = Randoms.pickNumberInRange(0, 9);

        if(randomValue>=4){
            //4보다 랜덤 값이 큰 경우 전진
            advanceCount+=1;
        }

    }

    public String progressStatus(){
        return this.name.concat(" : ")
                        .concat("-".repeat(advanceCount));
    }

    @Override
    public int compareTo(RacingCar o) {
        //오름차순 정렬
        return o.advanceCount-this.advanceCount;
    }
}
