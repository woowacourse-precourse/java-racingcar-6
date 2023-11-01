package racingcar.Domain;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {

    private static final Integer MOVE_LENGTH_START = 0;
    private static final Integer MOVE_LENGTH_END = 9;

    public String name;
    public Integer point;

    public Car(String name, Integer point) {
        this.name = name;
        this.point = point;
    }

    public String getName() {
        return name;
    }

    public Integer getPoint() {
        return point;
    }

    public void move() {
        Integer randomValue = createRandomValue();
        boolean randomValueValidation = checkRandomValueValidation(randomValue);

        if(randomValueValidation){
            moveCar(randomValue);
        }
    }

    public Integer createRandomValue() {
        Integer randomValue = Randoms.pickNumberInRange(0, 9);

        return randomValue;
    }

    public boolean checkRandomValueValidation(Integer randomValue) {
        if (randomValue >= 4){
            return true;
        }
        return false;
    }

    public void moveCar(Integer randomValue) {
        this.point += randomValue;
    }

}
