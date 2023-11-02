package racingcar.model;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Racer {
    public static final String SEPERATOR = ",";
    private final List<Car> racer;
    public Racer(String name) {
        validate(name);
        this.racer = Arrays.stream(name.split(SEPERATOR))
                .map(Car::new)
                .toList();
    }

    // TODO: 메서드 위치 고민 해보기
    public void play(){
        racer.forEach(Car::move);
    }

    public String getWinner() {
        Car winner = racer.stream().max(Car::compareTo).orElseThrow();
        return racer.stream().filter(winner::equals).map(Car::getName).collect(Collectors.joining(","));
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

    private void validate(String name){
        validateSize(name);
    }

    private void validateSize(String value){
        if (value == null || value.split(SEPERATOR).length == 0){
            throw new IllegalArgumentException("참가자 없음");
        }
    }
}
