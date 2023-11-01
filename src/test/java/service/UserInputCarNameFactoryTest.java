package service;

import domain.Cars;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import ui.Input;
import util.BeanFactory;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class UserInputCarNameFactoryTest {

    private UserInputCarNameFactory userInputCarNameFactory;

    @BeforeAll
    public void init(){
        this.userInputCarNameFactory = BeanFactory.getInstanceUserInputCarNameFactory();
    }

    @Test
    public void 이름이_BLANK_이면_예외_발생(){
        Input.input = ",,,";
        assertThrows(IllegalArgumentException.class,()->userInputCarNameFactory.createCars());
    }

    @Test
    public void 이름이_중복이면_예외_발생(){
        Input.input = "a,a,a";
        assertThrows(IllegalArgumentException.class,()->userInputCarNameFactory.createCars());
    }

    @Test
    public void createCars_하면_Cars_객체에_CarList_set_한다(){
        Input.input = "a,b,c";
        Cars cars = userInputCarNameFactory.createCars();
        for(char c='a';c<='c';c++){
            assertEquals(cars.getCars().get(c-97).getName(),c+"");
        }
    }


}