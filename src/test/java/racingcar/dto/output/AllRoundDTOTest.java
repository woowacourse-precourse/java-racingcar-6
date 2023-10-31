package racingcar.dto.output;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import org.junit.jupiter.api.Test;
import racingcar.common.type.Names;
import racingcar.domain.Car;

public class AllRoundDTOTest {

    @Test
    public void createAllRoundDTO_테스트() {
        // 준비
        List<Car> cars = Car.createCarList(Names.of(new String[]{"hyunjin", "pobi", "lefthand"}));

        // 실행
        AllRoundDTO allRoundDTO = AllRoundDTO.of(cars);

        // 확인
        assertEquals(3, allRoundDTO.roundDTOs().size());

        for (int i = 0; i < cars.size(); i++) {
            assertEquals(cars.get(i).getName(), allRoundDTO.roundDTOs().get(i).getName());
            assertEquals(cars.get(i).getDistance(), allRoundDTO.roundDTOs().get(i).getDistance());
        }
    }
}
