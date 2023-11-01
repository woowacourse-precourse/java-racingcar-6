package racingcar.Model;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    private String name;
    private int position;
    private RandomNumberGenerator randomNumberGenerator;

    public Car(String name){
        this.name=name;
        this.position=0;
        this.randomNumberGenerator=new RandomNumberGenertorImpI();
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public void move(){
        try {
            int randomValue = Randoms.pickNumberInRange(0, 9);
            if (randomValue >= 4) {
                position++;
            }
        } catch (Exception e) {
            System.err.println("랜덤 값 생성 오류: " + e.getMessage());
        }
    }

    public String getMovement(){
        return "-".repeat(position);
    }

}
