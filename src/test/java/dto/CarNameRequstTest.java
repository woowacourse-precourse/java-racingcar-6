package dto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.dto.CarNameRequst;

import static org.junit.jupiter.api.Assertions.*;

class CarNameRequstTest {

    @Test
    @DisplayName("이름 길이가 5초과이면 예외 발생")
    public void CarNameRequest_생성자에서_이름길이가_5초과인_경우_예외발생() throws Exception{
        assertThrows(
                IllegalArgumentException.class, () -> new CarNameRequst("i'm 김유진")
        );
    }
}