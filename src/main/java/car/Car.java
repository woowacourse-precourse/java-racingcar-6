package car;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    public int distance;
    public String name;

    public Car(String name){
        nameValidate(name);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getDistance() {
        return distance;
    }

    public int getRandomNumber() {
        return Randoms.pickNumberInRange(0,9);
    }

    public void move() {
        int randomNumber = getRandomNumber();
        if (randomNumber >= 4){
            distance++;
        }
    }

    public void nameValidate(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException("이름은 5글자 이하로 입력해주세요.");
        }
        else if (name.isEmpty()) {
            throw new IllegalArgumentException("이름이 입력되지 않았습니다.");
        }
    }
}
