package racingcar;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.config.Config;
import racingcar.model.Car;
import racingcar.service.CarService;
import racingcar.service.GameService;


public class GameServiceTest {

    private GameService gameService;
    private CarService carService;
    private Config config;

    @BeforeEach
    void setUp() {
        config = new Config();
        gameService = new GameService(config);
        carService = new CarService();
    }


    @Test
    void testSplitInputName() {
        // TODO: splitInputName 메서드를 테스트하기 위한 코드 작성
        // 준비: 입력값을 설정
        String input = "Car1,Car2,Car3";

        // 동작: splitInputName 호출
        gameService.splitInputName(input);

        // 검증: CarList에 Car 객체가 추가되었는지 확인
        assertEquals(3, gameService.carList.size());
        assertEquals("Car1", gameService.carList.get(0).getName());
        assertEquals("Car2", gameService.carList.get(1).getName());
        assertEquals("Car3", gameService.carList.get(2).getName());
    }

    @Test
    void testCarForward() {
        // TODO: carForward 메서드를 테스트하기 위한 코드 작성
        // 동작: carForward 호출
        carService.carForward(gameService.carList);

        // 검증: 각 Car 객체의 전진 값이 설정 범위 내에서 업데이트되었는지 확인
        for (Car car : gameService.carList) {
            int forward = car.getForward();
            assertTrue(forward >= Config.MIN_VALUE && forward <= Config.MAX_VALUE);
        }
    }

    @Test
    void testFindWinner() {
        // 준비: Car 객체 생성 및 전진 값 설정
        Car car1 = new Car("Car1");
        Car car2 = new Car("Car2");
        car2.increaseForward();
        Car car3 = new Car("Car3");
        car3.increaseForward();

        gameService.carList.add(car1);
        gameService.carList.add(car2);
        gameService.carList.add(car3);

        // 동작: findWinner 호출
        gameService.findWinner();

        // 검증: winnerList에 올바른 Car 객체가 추가되었는지 확인
        assertEquals(2, gameService.winnerList.size());
        assertEquals("Car2", gameService.winnerList.get(0).getName());
        assertEquals("Car3", gameService.winnerList.get(1).getName());


    }
}
