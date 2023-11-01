package racingcar.domain;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
//import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyInt;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import org.mockito.Mock;
import org.mockito.Mockito;
import racingcar.Application;

public class ManagerTest {

    private static final int POSSIBLE_TO_MOVE_NUMBER = 4;
    private static final int IMPOSSIBLE_TO_MOVE_NUMBER = 2;

    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 2;

    @DisplayName("매니저에게 차를 등록한다.")
    @Test
    void registerCarTest() {
        Manager manager = new Manager(1);
        Car car1 = new Car("a",1);
        Car car2 = new Car("b",1);

        manager.registerCar(car1);
        manager.registerCar(car2);

        Assertions.assertEquals(2,manager.getCarList().size());
    }

    @DisplayName("한바퀴가 끝나면 최댓값을 갱신한다.")
    @Test
    void manageMoveOneCycleTest() {
        Manager manager = new Manager(1);
        Car car1 = Mockito.mock(Car.class);
        Car car2 = Mockito.mock(Car.class);
        manager.registerCar(car1);
        manager.registerCar(car2);

        Mockito.when(car1.getMovementScore()).thenReturn(2);
        Mockito.when(car2.getMovementScore()).thenReturn(1);

        manager.manageOneCycle();

        Assertions.assertEquals(2,manager.getMaxMovingScore());
    }

    @DisplayName("공동 우승자가 있으면 모두 반환 리스트에 담는다.")
    @Test
    void announceWinner() {
        Manager manager = new Manager(1);
        Car car1 = Mockito.mock(Car.class);
        Car car2 = Mockito.mock(Car.class);
        Car car3 = Mockito.mock(Car.class);
        manager.registerCar(car1);
        manager.registerCar(car2);
        manager.registerCar(car3);

        Mockito.when(car1.getMovementScore()).thenReturn(3);
        Mockito.when(car2.getMovementScore()).thenReturn(3);
        Mockito.when(car3.getMovementScore()).thenReturn(1);

        manager.manageOneCycle();
        int result = manager.announceWinner().size();

        Assertions.assertEquals(2,result);
    }

    @DisplayName("사이클을 돌 때 마다 남은 사이클 수를 감소한다.")
    @Test
    void getRemainingCycle() {
        Manager manager = new Manager(3);

        manager.manageOneCycle();
        manager.manageOneCycle();

        Assertions.assertEquals(1,manager.getRemainingCycle());
    }

}

//    public static void assertRandomNumberInRangeTest(
//            final Executable executable, // 실행할 테스트 로직을 람다 형식으로 전달
//            final Integer value, // 난수 생성기가 반환해야할 순차적인 값들
//            final Integer... values // 난수 생성기가 반환해야할 순차적인 값들
//    ) {
//        // 실제 난수 생성기의 결과를 제어함
//        assertRandomTest(
//                () -> Randoms.pickNumberInRange(anyInt(), anyInt()),
//                executable,
//                value,
//                values
//        );
//    }
//    @Override
//    public void runMain() {
//        Application.main(new String[]{});
//    }
//
//    @DisplayName("max값 갱신 테스트")
//    @RepeatedTest(10)
//    void manageMoveOneCycleTest() {
//
//        assertRandomNumberInRangeTest(
//                () -> {
//                    run("pobi,giki","2");
////                    assertThat(output()).contains("pobi : -", "woni : ", "최종 우승자 : pobi");
//                },
//                MOVING_FORWARD, STOP
//        );
//
//        Car car = new Car("test",1);
//        int result = car.pickRandomNumberToMove();
//        System.out.println(result);

//        Manager manager = new Manager(1);
//        Car car1 = Mockito.mock(Car.class); // Car 목 객체 생성
//        Car car2 = Mockito.mock(Car.class);
//
//        // 목 객체들의 초기 상태 설정.
//        Mockito.when(Randoms.pickNumberInRange(0,9)).thenReturn(IMPOSSIBLE_TO_MOVE_NUMBER);
//        int result = car1.pickRandomNumberToMove();
//        car1.tryToGetMovementScore();
//
//
//        Mockito.when(car2.pickRandomNumberToMove()).thenReturn(POSSIBLE_TO_MOVE_NUMBER);
//        int result2 = car2.pickRandomNumberToMove();
//        car2.tryToGetMovementScore();
//
//        manager.registerCar(car1);
//        manager.registerCar(car2);
//
//        manager.manageOneCycle();
//
//        Assertions.assertEquals(1, manager.getMaxMovingScore());
//    }