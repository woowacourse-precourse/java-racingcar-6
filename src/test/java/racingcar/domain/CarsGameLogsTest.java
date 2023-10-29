package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.LinkedHashMap;
import java.util.Map;
import org.assertj.core.data.Index;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarsGameLogsTest {
    @Test
    @DisplayName("경주 로그 초기값 생성 완료")
    void 경주_로그_초기값() throws Exception {
        //given
        Map<String,Integer> carsPosition = new LinkedHashMap<>(Map.of("A",-3,"B",0,"C",-1));
        //when
        CarsGameLogs carsGameLogs = new CarsGameLogs(carsPosition);
        //then
        assertThat(carsGameLogs.getLogs()).isEqualTo(Map.of("A","","B","","C",""));
    }

    @Test
    @DisplayName("경주 로그 업데이트")
    void update() throws Exception {
        //given
        CarsGameLogs carsGameLogs = new CarsGameLogs(Map.of("A", 1, "B", 1));
        //when
        carsGameLogs.update("A", 1);
        carsGameLogs.update("B",0);
        //then
        assertThat(carsGameLogs.getLogs().get("A")).isEqualTo("-");
        assertThat(carsGameLogs.getLogs().get("B")).isEqualTo("");
    }

}