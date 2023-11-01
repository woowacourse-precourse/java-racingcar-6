package racingcar.dto.output;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.domain.Car;

public final class RoundDTO {
    private final String name;
    private final int distance;

    private RoundDTO(String name, int distance) {
        this.name = name;
        this.distance = distance;
    }

    // Car 리스트를 RoundDTO 리스트로 변환
    public static List<RoundDTO> of(List<Car> cars) {
        return cars.stream()
                .map(RoundDTO::carToRoundDTO)
                .collect(Collectors.toList());
    }

    //Car를 RoundDTO로 변환
    private static RoundDTO carToRoundDTO(Car car) {
        return new RoundDTO(car.getName(), car.getDistance());
    }

    public String getName() {
        return name;
    }

    public int getDistance() {
        return distance;
    }
}
