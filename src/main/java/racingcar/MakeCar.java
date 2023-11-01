package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class MakeCar implements Comparable<MakeCar> {

    public String carName;
    public int carScore;

    public void oneRound(){ //라운드가 한번 지날때마다 scoreplus or notscore
        if(goOrNotGo())
            carScore++;
    }
    public boolean goOrNotGo(){ //랜덤값 돌려서 4 이상이면 true반환, 3이하면 false반환
        if(Randoms.pickNumberInRange(0,9)>=4)
            return true;
        else
            return false;
    }

    public void carLocationPrint(){ //자동차의 위치 출력
        System.out.print(carName+" : ");
        for(int i = 0;i<carScore;i++)
            System.out.print("-");
        System.out.println();
    }
    @Override//자동차객체를 스코어순으로 정렬하기위해 선언.
    public int compareTo(MakeCar other){
        return other.carScore - this.carScore;
    }


}
