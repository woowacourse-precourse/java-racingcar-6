//package racingcar.domain;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//
//import java.util.Arrays;
//import java.util.List;
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.Test;
//
//class RaceResultTest {
//
//    @Test
//    @DisplayName("CarSnapshot은 Car의 상태를 저장한다")
//    void testCarSnapshotAfterMove() {
//        Car car1 = new Car("car1");
//        Car car2 = new Car("car2");
//        Car car3 = new Car("car3");
//
//        // TODO: move()의 랜덤 생성이 분리되지 않아 테스트가 불가능(전략 패턴을 적용해서 move가 랜덤 생성을 의존하지 않도록 수정해야 함)
//        car1.move();
//        car2.move();
//        car3.move();
//        car3.move();
//
//        RaceResult raceResult = new RaceResult();
//        raceResult.addRoundResult(Arrays.asList(car1, car2, car3));
//
//        List<RaceResult.RoundResult> results = raceResult.getRoundResults();
//        RaceResult.RoundResult roundResult = results.get(0);
//        RaceResult.CarSnapshot snapshotForCar1 = roundResult.getSnapshotForCarName("car1");
//        RaceResult.CarSnapshot snapshotForCar2 = roundResult.getSnapshotForCarName("car2");
//        RaceResult.CarSnapshot snapshotForCar3 = roundResult.getSnapshotForCarName("car3");
//
//        assertEquals(1, snapshotForCar2.getPosition());
//        assertEquals(1, snapshotForCar1.getPosition());
//        assertEquals(2, snapshotForCar3.getPosition());
//    }
//}
