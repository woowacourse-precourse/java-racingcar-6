package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {

    private final String name;
    private int distance;

    /**
     * car의 생성자.
     * 이름을 인자로 받아 저장하고, 거리를 0으로 초기화한다.
     */
    public Car(String name){
        this.name = name;
        this.distance=0;
    }

    /**
     * 랜덤한 값을 사용하여 4이상일 경우 1칸 움직이는 함수.
     */
    public void move(){
        if(Randoms.pickNumberInRange(0,9)>=4){
            this.distance++;
        }
    }

    /**
     * 이름과 이동한 거리에 대한 getter, setter
     */
    public String getName(){
        return this.name;
    }

    public int getDistance(){
        return this.distance;
    }

    /**
     * 현재 자동차의 상황을 String 형식으로 출력하는 함수.
     * 자동차 이름과 이동한 거리를 표시한다.
     * @return "pobi : ----\n"
     */
    @Override
    public String toString() {
        String res = "";
        res+=this.name;
        res+=" : ";
        res+="-".repeat(distance);
        res+="\n";
        return res;
    }
}
