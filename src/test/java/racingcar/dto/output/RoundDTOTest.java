package racingcar.dto.output;

import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import racingcar.common.type.Names;
import racingcar.domain.Car;

public class RoundDTOTest {

    @Test
    public void createRoundDTOList_테스트() {
        // 준비
        List<Car> cars = Car.createCarList(Names.of(new String[]{"hyunjin", "pobi", "lefthand"}));

        // 실행
        List<RoundDTO> roundDTOs = RoundDTO.of(cars);

        // 확인
        Assertions.assertEquals(3, roundDTOs.size());

        for (int i = 0; i < cars.size(); i++) {
            Assertions.assertEquals(cars.get(i).getName(), roundDTOs.get(i).getName());
            Assertions.assertEquals(cars.get(i).getDistance(), roundDTOs.get(i).getDistance());
        }
    }
}
