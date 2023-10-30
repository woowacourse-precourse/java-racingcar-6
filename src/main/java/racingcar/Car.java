package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {

    private String name;
    private int forwardCount;

    public Car(String name) { // 생성자로 자동차의 이름을 받음
        if(name.length() > 5){
            throw new IllegalArgumentException("이름은 5자까지만 입력 가능");
        }

        this.name = name;
    } // Contructor

    public void forward(){ // 경주 차의 전진을 담당하는 메소드, 랜덤값이 4이상일 경우에만 전진

        int randomNumber = Randoms.pickNumberInRange(0, 9);

        if(randomNumber >= 4){
            forwardCount++;
        }

    } // forward

    public String getName() {
        return name;
    }

    public int getForwardCount() {
        return forwardCount;
    }
} // end class
