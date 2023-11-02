package racingcar.model;

import racingcar.util.ValidateSize;

import java.util.Arrays;
import java.util.List;

public class Racer {
    public static final String SEPERATOR = ",";
    private final List<Car> racer;
    public Racer(String name) {
        validateSize(name);
        this.racer = Arrays.stream(name.split(SEPERATOR))
                .map(Car::new)
                .toList();
    }

    // TODO: 메서드 위치 고민 해보기
    public void play(){
        racer.forEach(Car::move);
    }

    @Override
    public String toString(){
        StringBuilder stringBuilder = new StringBuilder();
        for (Car car : racer){
            stringBuilder.append(car.toString()).append("\n");
        }
        return stringBuilder.toString();
    }

    @Override
    public boolean equals(Object obj){
        if (this == obj){
            return true;
        }

        if (!(obj instanceof Racer target)){
            return false;
        }

        return racer.equals(target.racer);
    }

    private void validateSize(String name){
        ValidateSize.check(name);
    }
}
