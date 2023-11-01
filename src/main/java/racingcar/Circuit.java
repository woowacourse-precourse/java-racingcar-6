package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;

public class Circuit {
    public Circuit(ArrayList<Car> carArrayList){
        for(int i=0;i<carArrayList.size();i++){//각 자동차별 전진 여부 판별하는 반복문

            if(RandomDistance()){
                carArrayList.get(i).distance=carArrayList.get(i).distance+1;
            }
            System.out.println(carArrayList.get(i).name+" : "+"-".repeat(carArrayList.get(i).distance));

        }
        System.out.println();
    }
    //랜덤값이 4이상일 경우 전진 여부 결정하는 함수
    public static boolean RandomDistance(){
        int n=Randoms.pickNumberInRange(0,9);

        if(n>3)
            return true;

        return false;
    }
}
