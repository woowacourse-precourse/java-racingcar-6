package racingcar.common.validator;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import racingcar.common.type.Name;


public class NamesValidatorTest {
    @Test
    public void 이름_목록_비어있음_예외_발생() {
        List<Name> nameList = Collections.emptyList();
        Assertions.assertThrows(IllegalArgumentException.class, () -> NamesValidator.validate(nameList));
    }

    @Test
    public void 중복된_이름_예외_발생() {
        List<Name> nameList = Arrays.asList(Name.of("pobi"), Name.of("pobi"));
        Assertions.assertThrows(IllegalArgumentException.class, () -> NamesValidator.validate(nameList));
    }

    @Test
    public void 참가자_수_불충분_예외_발생() {
        List<Name> nameList = List.of(Name.of("pobi"));
        Assertions.assertThrows(IllegalArgumentException.class, () -> NamesValidator.validate(nameList));
    }

    @Test
    public void pobi와_javaji_동시_참가_예외_발생() {
        List<Name> nameList = Arrays.asList(Name.of("pobi"), Name.of("javaji"));
        Assertions.assertThrows(IllegalArgumentException.class, () -> NamesValidator.validate(nameList));
    }
}
