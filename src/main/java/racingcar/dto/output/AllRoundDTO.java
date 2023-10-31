package racingcar.dto.output;

import java.util.List;
import racingcar.domain.Car;

public final class AllRoundDTO {
    private final List<RoundDTO> roundDTOs;

    public static AllRoundDTO of(List<Car> cars) {
        return new AllRoundDTO(RoundDTO.of(cars));
    }

    private AllRoundDTO(List<RoundDTO> roundDTOs) {
        this.roundDTOs = roundDTOs;
    }

    public List<RoundDTO> roundDTOs() {
        return roundDTOs;
    }
}
