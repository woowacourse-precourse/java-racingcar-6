package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import com.sun.source.tree.AssertTree;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import racingcar.model.Car;
import racingcar.service.CarManageService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class CarManageServiceTest extends NsTest {
    CarManageService carManageService = new CarManageService();

    @Test
    public void 차량_이름들_분리_후_리스트화(){
        //given
        String test1 = "lucy,tom";
        String test2 = "lucy,tooooom";
        String test3 = "lucy,     ";
        String test4 = "";
        String test5 = "lucy,tom,tom";


        //when & then
        Assertions.assertEquals(Arrays.asList("lucy","tom"), carManageService.createCarNameList(test1));
        Assertions.assertThrows(IllegalArgumentException.class,() -> carManageService.createCarNameList(test2));
        Assertions.assertThrows(IllegalArgumentException.class,() -> carManageService.createCarNameList(test3));
        Assertions.assertThrows(IllegalArgumentException.class,() -> carManageService.createCarNameList(test4));
        Assertions.assertThrows(IllegalArgumentException.class,() -> carManageService.createCarNameList(test5));
    }

    @Test
    public void CAR_객체_생성(){
        //given
        List<String> test1 = Arrays.asList("lucy", "tom");

        //when & then
        List<Car> cars = carManageService.createCars(test1);
        IntStream.range(0, cars.size()).forEach(idx -> {
            Assertions.assertEquals(cars.get(idx).getName(), test1.get(idx));
            Assertions.assertEquals(cars.get(idx).getPoint(), 0);
        });
    }

    @Test
    public void 포인트로_CAR_리스트_정렬_내림차순_CASE1(){
        //given
        List<Car> test1 = Arrays.asList(new Car("lucy"),new Car("tom"),new Car("hemy"),new Car("hewo"));
        List<Integer> testNum1 = new ArrayList<>(Arrays.asList(3,7,5,6));
        IntStream.range(0, test1.size()).forEach(idx -> {
            test1.get(idx).setPoint(testNum1.get(idx));
        });
        List<String> answer1 = Arrays.asList("tom","hewo","hemy","lucy");

        //when
        carManageService.sortCarsByPoint(test1);

        //then
        IntStream.range(0, test1.size()).forEach(idx -> {
            Assertions.assertEquals(test1.get(idx).getName(),answer1.get(idx));
        });
    }

    @Test
    public void 포인트로_CAR_리스트_정렬_내림차순_CASE2(){
        //given
        List<Car> test1 = Arrays.asList(new Car("lucy"),new Car("tom"),new Car("hemy"),new Car("hewo"));
        List<Integer> testNum1 = new ArrayList<>(Arrays.asList(3,7,7,6));
        IntStream.range(0, test1.size()).forEach(idx -> {
            test1.get(idx).setPoint(testNum1.get(idx));
        });
        List<String> answer1 = Arrays.asList("tom","hemy","hewo","lucy");

        //when
        carManageService.sortCarsByPoint(test1);

        //then
        IntStream.range(0, test1.size()).forEach(idx -> {
            Assertions.assertEquals(test1.get(idx).getName(),answer1.get(idx));
        });
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
