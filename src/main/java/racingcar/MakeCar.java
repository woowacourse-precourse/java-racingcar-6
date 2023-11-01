package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class MakeCar implements Comparable<MakeCar> {

    public String carName;
    public int carScore;

    public void oneRound(){
        if(goOrNotGo())
            carScore++;
    }
    public boolean goOrNotGo(){
        if(Randoms.pickNumberInRange(0,9)>=4)
            return true;
        else
            return false;
    }

    public void carLocationPrint(){
        System.out.print(carName+" : ");
        for(int i = 0;i<carScore;i++)
            System.out.print("-");
        System.out.println();
    }
    @Override
    public int compareTo(MakeCar other){
        return other.carScore - this.carScore;
    }


}
