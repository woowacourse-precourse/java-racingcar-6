package racingcar.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.service.CarNameService;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class CarNameServiceTest {

    private CarNameService carNameService;
    @BeforeEach
    void setUp(){
        carNameService = new CarNameService();
    }

    @Test
    void 이름입력받기_공백포함시_예외처리(){
        String input = "abc, ,de,f";
        assertThrows(IllegalArgumentException.class, ()->
                carNameService.convertStrToList(input));
    }
    @Test
    void 이름입력받기_입력값없을때_예외처리(){
        String input = "abc,,,,,de,f";
        assertThrows(IllegalArgumentException.class, ()->
                carNameService.convertStrToList(input));
    }
    @Test
    void 이름입력받기_길이5이상일때_예외처리(){
        String input = "abc,de,fghijk";
        assertThrows(IllegalArgumentException.class, ()->
                carNameService.convertStrToList(input));
    }

    @Test
    void 이름입력받은후_저장된_값_확인(){
        String input = "a,b,c,d";
        List<String> expect = new ArrayList<>();
        expect.add("a");
        expect.add("b");
        expect.add("c");
        expect.add("d");

        List<String> value = carNameService.convertStrToList(input);

        assertThat(value).isEqualTo(expect);
    }

}