package racingcar.domain;

import java.util.List;

public class Participations { // 일급컬렉션  //TODO: Winners와 Participations의 공통점이 많으면 추상화하기
    private List<Car> participations;

    public Participations() {
    }

    public Participations(List<Car> carList) {
        participations = carList;
    }

    public int size() {
        return participations.size();
    }
}
