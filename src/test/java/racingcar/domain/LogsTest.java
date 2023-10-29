package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.LinkedHashMap;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LogsTest {
    @Test
    @DisplayName("경주 로그 초기값 생성 완료")
    void 경주_로그_초기값() throws Exception {
        //given
        Map<String,Integer> carsPosition = new LinkedHashMap<>(Map.of("A",-3,"B",0,"C",-1));
        //when
        Logs logs = new Logs(carsPosition);
        //then
        assertThat(logs.getLogs()).isEqualTo(Map.of("A","","B","","C",""));
    }

    @Test
    @DisplayName("경주 로그 업데이트")
    void update() throws Exception {
        //given
        Logs logs = new Logs(Map.of("A", 1, "B", 1));
        //when
        logs.update("A", 1);
        logs.update("B",0);
        //then
        assertThat(logs.getLogs().get("A")).isEqualTo("-");
        assertThat(logs.getLogs().get("B")).isEqualTo("");
    }

}