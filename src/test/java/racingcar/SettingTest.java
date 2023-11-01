package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import exception.ExceededStringException;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.StringTokenizer;

import static org.junit.jupiter.api.Assertions.*;

public class SettingTest{

    // ,으로 네임 파싱을 잘 하는가 : settingName()
    //글자수 5자 이하면 이름을 잘 저장하는가 (입력한 개수만큼 저장이 잘 되는가)
    @Test
    void 입력값_파싱하고_저장(){
        //given
        String input = "aaa,bbb,ccc,dd,eeee,ffff";
        Setting setting = new Setting();
        int nameCount = 0;

        //when
        setting.settingName(input);
        List<Car> cars = setting.getCars();
        StringTokenizer st = new StringTokenizer(input, ",");

        //then
        for (Car car : cars) {
            assertEquals(car.getName(), st.nextToken());
            nameCount++;
        }
        assertEquals(nameCount, cars.size());
    }

    //글자수 5자 넘으면 예외를 잘 터트리나
    @Test
    void 이름길이_예외발생(){
        //given
        String input = "aaaaaa,bbbbbbb";
        Setting setting = new Setting();

        //when, then
        assertThrows(ExceededStringException.class, () -> {
            setting.settingName(input);
        });
    }

    //이름이 1개 입력되어도 (,가 없어도) 잘 저장되는가
    @Test
    void 입력값이_1개(){
        //given
        String input = "aaaaa";
        Setting setting = new Setting();

        //when
        StringTokenizer st = new StringTokenizer(input, ",");
        setting.settingName(input);

        //then
        List<Car> cars = setting.getCars();
        assertEquals(st.nextToken(), cars.get(0).getName());
    }
}
