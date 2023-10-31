package racingcar.common.type;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class NameTest {
    @Test
    public void 이름_생성() {
        Name name = Name.of("hyunjin");
        Assertions.assertEquals("hyunjin", name.getName());
    }

    @Test
    public void 이름_조회() {
        Name name = Name.of("hyunjin");
        Assertions.assertEquals("hyunjin", name.getName());
    }

    @Test
    public void 이름_앞뒤_공백() {
        Name name = Name.of(" hyunjin ");
        Assertions.assertEquals("hyunjin", name.getName());
    }

    @Test
    public void 이름_중복_테스트() {
        Name name = Name.of("hyunjin");
        Name duplicatedName = Name.of("hyunjin");

        Assertions.assertEquals(name, duplicatedName);
    }
}
