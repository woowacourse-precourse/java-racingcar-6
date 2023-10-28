package racingcar.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Car {

    private List<String> car = new ArrayList<>();

    public Car(String carMembers) {
        this.car = setCarMembers(carMembers);
        isLessThanFive(car);
        isMoreThanTwoCars(car);
    }

    public List<String> getCarMembers() {
        return car;
    }

    public List<String> setCarMembers(String carMembers) {
        return Arrays.asList(carMembers.split(","));
    }

    public void isLessThanFive(List<String> members) throws IllegalArgumentException {
        for (String member : members) {
            if (member.length() > 5) {
                throw new IllegalArgumentException("자동차 이름이 5글자 이하가 아닙니다.");
            }
        }
    }

    public void isMoreThanTwoCars(List<String> members) throws IllegalArgumentException {
        if (members.size() == 1) {
            throw new IllegalArgumentException("2대 이상의 자동차 이름을 입력해주세요.");
        }
    }
}
