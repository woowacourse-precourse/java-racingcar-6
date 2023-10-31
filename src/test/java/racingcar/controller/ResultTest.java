package racingcar.controller;

import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.common.type.Names;
import racingcar.domain.Car;
import racingcar.domain.RacingWinners;
import racingcar.dto.output.WinnerDTO;

public class ResultTest {

    private RacingWinners racingWinners;

    @BeforeEach
    public void setUp() {
        // given: 예상되는 우승자 이름 목록 설정
        Names names = Names.of(new String[]{"hyunjin", "pobi", "lefthand"});
        List<Car> carList = Car.createCarList(names);
        racingWinners = RacingWinners.of(carList);
    }

    @Test
    public void 우승자_발표_테스트() {
        // given: Result 객체 생성
        Result result = Result.of(racingWinners);

        // when: 우승자 발표
        WinnerDTO winnerDTO = result.announce();

        // then: 결과 검증
        String announcedWinners = winnerDTO.toString();
        Assertions.assertEquals("최종 우승자 : hyunjin,pobi,lefthand", announcedWinners);
    }
}
