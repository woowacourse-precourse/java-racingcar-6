package racingcar.entity;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Game {
    public Game(Integer playCount) {
        this.playCount = playCount;
    }

    private List<Car> carList = new ArrayList<>();

    private Integer playCount;

    public void addCar(Car car) {
        carList.add(car);
    }

    public List<String> getCarNameList() {
        return carList.stream()
                .map(car -> car.getName())
                .collect(Collectors.toList());
    }

    public Integer getPlayCount() {
        return playCount;
    }

    public void setPlayCount(Integer playCount) {
        this.playCount = playCount;
    }

    public boolean carGoOrStop() {
        int pivot=4;
        int number= Randoms.pickNumberInRange(0, 9);
        if(number>=pivot) return true;
        return false;
    }
}
