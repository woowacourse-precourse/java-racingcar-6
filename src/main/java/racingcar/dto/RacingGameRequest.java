package racingcar.dto;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.domain.car.Car;
import racingcar.domain.gennerator.RandomNumberGenerator;

public class RacingGameRequest {

    private final List<Car> cars;
    private final int count;

    public RacingGameRequest(String names, String count) {
        validateCount(count);
        this.cars= toList(names);
        this.count= toInt(count);
    }

    public List<Car> getCars() {
        return cars;
    }

    public int getCount() {
        return count;
    }

    private static int toInt(String count) {
        return Integer.parseInt(count);
    }

    private static List<Car> toList(String names) {
        return Arrays.stream(names.split(","))
                .map(String::trim)
                .map(name -> new Car(name, new RandomNumberGenerator()))
                .collect(Collectors.toList());
    }

    private void validateCount(String count) {
        try {
            Integer.parseInt(count);
        }catch (NumberFormatException ex){
            throw new IllegalArgumentException("숫자로 입력해주세요");
        }
    }
}
