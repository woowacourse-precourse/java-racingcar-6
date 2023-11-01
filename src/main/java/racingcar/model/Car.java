package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {

    private Name name;
    private Distance distance;

    public Car(Name name) {

        if (name == null) {
            throw new IllegalArgumentException("이름은 null일 수 없습니다.");
        }

        this.name = name;
        this.distance = new Distance();
    }

    public String getMyName() {
        return name.toString();
    }

    public boolean isNamesake(Car car) {
        return this.name.equals(car.name);
    }

    /**
     * @return ex. "pobi : ---"
     */
    @Override
    public String toString() {
        return name + " : " + distance;
    }

    /**
     * 10번 중 6번 꼴로 전진한다.
     * @return 전진한 경우 true를, 그렇지 않은 경우 false를 반환한다.
     */
    public boolean drive() {
        int picked = Randoms.pickNumberInRange(0, 9);
        if (picked >= 4) {
            return distance.increaseByOne();
        }
        return false;
    }
}
