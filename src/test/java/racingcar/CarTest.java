package racingcar;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class CarTest {

    //goStop()이 실행되었을 때 모든 car들의 distance가 이전보다 크거나 같은가
    @Test
    void goStopTest(){
        //given
        String input = "aaa,bb,c,dd";
        Setting setting = new Setting();
        List<Car> cars = setting.settingName(input);
        int beforeDistance, afterDistance;

        for(Car car:cars){
            beforeDistance = car.getDistance();

            //when
            car.goStop();
            afterDistance = car.getDistance();

            //then
            Assertions.assertTrue(beforeDistance<=afterDistance);
        }
    }

}
