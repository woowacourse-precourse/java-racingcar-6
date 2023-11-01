package racingcar.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RacingCarServiceTest {
    @Test
    @DisplayName("getWinner_1명_테스트")
    void getWinner_1명_테스트() throws Exception {
        //given
        RacingCarService service = RacingCarService.getInstance();
        List<String> carNames = new ArrayList<>();
        carNames.add("pobi");
        carNames.add("woni");
        carNames.add("jun");

        HashMap<String, Integer> racingStatus = new HashMap<>();
        racingStatus.put("pobi", 5);
        racingStatus.put("woni", 3);
        racingStatus.put("jun", 2);

        //when
        List<String> winnerList = service.getWinner(carNames, racingStatus);

        //then
        assertThat(winnerList.size()).isEqualTo(1);
        assertThat(winnerList.get(0)).isEqualTo("pobi");
    }

    @Test
    @DisplayName("getWinner_1명이상_테스트")
    void getWinner_1명이상_테스트() throws Exception {
        //given
        RacingCarService service = RacingCarService.getInstance();
        List<String> carNames = new ArrayList<>();
        carNames.add("pobi");
        carNames.add("woni");
        carNames.add("jun");

        HashMap<String, Integer> racingStatus = new HashMap<>();
        racingStatus.put("pobi", 5);
        racingStatus.put("woni", 5);
        racingStatus.put("jun", 5);

        //when
        List<String> winnerList = service.getWinner(carNames, racingStatus);

        //then
        assertThat(winnerList.size()).isEqualTo(3);
        assertThat(winnerList.get(0)).isEqualTo("pobi");
        assertThat(winnerList.get(1)).isEqualTo("woni");
        assertThat(winnerList.get(2)).isEqualTo("jun");
    }

    @Test
    @DisplayName("initRacingStatus_테스트")
    void initRacingStatus_테스트() throws Exception {
        //given
        RacingCarService service = RacingCarService.getInstance();
        List<String> carNames = new ArrayList<>();
        carNames.add("pobi");
        carNames.add("woni");
        carNames.add("jun");

        //when
        HashMap<String, Integer> racingStatus = service.initRacingStatus(carNames);

        //then
        assertThat(racingStatus.size()).isEqualTo(3);
        assertThat(racingStatus.get("pobi")).isEqualTo(0);
    }


}