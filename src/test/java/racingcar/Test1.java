package racingcar;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;
import domain.Car;
import domain.InputView.InputNames;
import domain.InputView.InputTurn;
import domain.InputView.NameValidiator;
import org.junit.jupiter.api.Test;


public class Test1 {
    @Test
    void Car객체_초기화(){
        Car car=new Car("geonwoo");
        assertEquals(car.getName(), "geonwoo");
        assertEquals(car.getPosition(),0);
    }

    @Test
    void End_Delimiter_Test() {
        assertThrows(IllegalArgumentException.class, ()-> {
            NameValidiator check = new NameValidiator("java,");
        });
    }

    @Test
    void Blank_Test() {
        assertThrows(IllegalArgumentException.class, ()-> {
            NameValidiator check = new NameValidiator("");
        });
    }

    @Test
    void check_Duplicate() {
        assertThrows(IllegalArgumentException.class, ()-> {
            InputNames check = new InputNames();
            check.ParsingInput("java,java");
        });
    }

    @Test
    void check_Long_Names() {
        assertThrows(IllegalArgumentException.class, ()-> {
            InputNames check = new InputNames();
            check.ParsingInput("javaji,java");
        });
    }

    @Test
    void check_Empty_Names() {
        assertThrows(IllegalArgumentException.class, ()-> {
            InputNames check = new InputNames();
            check.ParsingInput("j,,java");
        });
    }

    @Test
    void check_Wrong_Names() {
        assertThrows(IllegalArgumentException.class, ()-> {
            InputNames check = new InputNames();
            check.ParsingInput("#,#");
        });
    }

    @Test
    void check_Not_Number1() {
        assertThrows(IllegalArgumentException.class, ()-> {
            InputTurn check = new InputTurn();
            check.inputToInt("a");
        });
    }

    @Test
    void check_Not_Number2() {
        assertThrows(IllegalArgumentException.class, ()-> {
            InputTurn check = new InputTurn();
            check.inputToInt("123,");
        });
    }

    @Test
    void check_Zero() {
        assertThrows(IllegalArgumentException.class, ()-> {
            InputTurn check = new InputTurn();
            check.inputToInt("0");
        });
    }

    @Test
    void check_Negative_Number() {
        assertThrows(IllegalArgumentException.class, ()-> {
            InputTurn check = new InputTurn();
            check.inputToInt("-1");
        });
    }



}
