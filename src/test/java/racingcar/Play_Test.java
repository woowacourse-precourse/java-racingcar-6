package racingcar;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import racingcar.util.Car;
import racingcar.util.Move_Selector;
import racingcar.util.Play;

import java.util.ArrayList;
import java.util.List;

public class Play_Test {

    public static final Move_Selector move_selector = () -> true;
    @Test
    void One_Round_테스트(){
        Car car1 = new Car("pobi",0);
        Car car2 = new Car("min",0);
        Car car3 = new Car("woni",0);
        Car car4 = new Car("jin",0);
        List<Car> car = new ArrayList<Car>();
        car.add(car1);
        car.add(car2);
        car.add(car3);
        car.add(car4);
        Play play = new Play(car,5);
        play.One_Round(move_selector);
        assertEquals(car1.Get_Position(),1);
        assertEquals(car2.Get_Position(),1);
        assertEquals(car3.Get_Position(),1);
        assertEquals(car4.Get_Position(),1);
        play.One_Round(move_selector);
        assertEquals(car1.Get_Position(),2);
        assertEquals(car2.Get_Position(),2);
        assertEquals(car3.Get_Position(),2);
        assertEquals(car4.Get_Position(),2);
        play.One_Round(move_selector);
        assertEquals(car1.Get_Position(),3);
        assertEquals(car2.Get_Position(),3);
        assertEquals(car3.Get_Position(),3);
        assertEquals(car4.Get_Position(),3);
        play.One_Round(move_selector);
        assertEquals(car1.Get_Position(),4);
        assertEquals(car2.Get_Position(),4);
        assertEquals(car3.Get_Position(),4);
        assertEquals(car4.Get_Position(),4);
        play.One_Round(move_selector);
        assertEquals(car1.Get_Position(),5);
        assertEquals(car2.Get_Position(),5);
        assertEquals(car3.Get_Position(),5);
        assertEquals(car4.Get_Position(),5);
    }
    @Test
    void Check_Round_over_테스트(){
        Car car1 = new Car("pobi",0);
        List<Car> car = new ArrayList<Car>();
        car.add(car1);
        Play play = new Play(car,5);
        boolean Result = true;
        while(Result){
            play.One_Round(move_selector);
            assertTrue(Result);
            Result = play.Check_Round_Over();
        }
        assertFalse(Result);
    }
}
