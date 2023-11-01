package service;

import com.sun.jdi.InvalidTypeException;
import dto.UserInputCarMoveCountDto;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import ui.Input;
import util.BeanFactory;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class UserInputCarMoveCountFactoryTest {

    private UserInputCarMoveCountFactory userInputCarMoveCountFactory;

    @BeforeAll
    public void init(){
        this.userInputCarMoveCountFactory = BeanFactory.getInstanceUserInputCarMoveCountFactory();
    }

    @Test
    public void 숫자_이외의_값_입력시_예외_발생() throws InvalidTypeException {
        Input.input = "한글";
        assertThrows(InvalidTypeException.class,() -> userInputCarMoveCountFactory.createUserInputCarMoveCountDto());
    }

    @Test
    public void 너무_큰_숫자_입력시_예외_발생(){
        Input.input = (Integer.MAX_VALUE + 10000L) + "";
        assertThrows(IllegalArgumentException.class, () -> userInputCarMoveCountFactory.createUserInputCarMoveCountDto());
    }

    @Test
    public void 숫자_입력시_이동_객체_생성() throws InvalidTypeException {
        Input.input = 1000 + "";
        assertEquals(1000,userInputCarMoveCountFactory.createUserInputCarMoveCountDto().getMoveCount());
    }

}