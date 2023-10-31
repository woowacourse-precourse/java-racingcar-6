package racingcar.common.type;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.Test;

class NamesTest {
    @Test
    public void 이름_목록_생성() {
        Names names = Names.of(new String[]{"pobi", "lefthand", "hyunjin"});
        assertEquals(List.of("pobi", "lefthand", "hyunjin"), names.getNameList());
    }
}
