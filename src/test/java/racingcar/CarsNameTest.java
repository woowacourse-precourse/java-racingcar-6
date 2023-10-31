package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import racingcar.model.Participant;
import racingcar.model.Participants;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class CarsNameTest {

    @DisplayName("참가 자동차 이름 가져오기 테스트")
    @ParameterizedTest
    @CsvSource({"1,pobi","2,woni","3,jun","4,debbie"})
    void getNameTest(int idx, String name) {
        Participant participant = new Participant(idx, name);
        Participants participants = new Participants();
        participants.addParticipant(participant);
        HashMap<Integer, Participant> participantMap = participants.getParticipants();
        assertTrue(participantMap.containsKey(idx));
        assertEquals(participantMap.get(idx), participant);
    }

//    @DisplayName("자동차 정보 가져오기 결과 테스트")
//    @MethodSource("generateCarAndMovement")
//    @ParameterizedTest
//    void getCarInformationTest(String name, List<MovementState> movementStates,
//                               List<Object> expectResult) {
//        Car car = new Car(name);
//        for (MovementState movementState : movementStates) {
//            car.addPosition(movementState);
//        }
//
//        assertThat(car.getCarInformation()).isEqualTo(expectResult);
//    }

//    static Stream<Arguments> generateCarAndMovement() {
//        MovementState go = MovementState.GO;
//        MovementState stop = MovementState.STOP;
//
//        return Stream.of(
//                Arguments.of("pobi", Arrays.asList(go, go, go, go),
//                        Arrays.asList("pobi", 4)),
//                Arguments.of("woni", Arrays.asList(go, stop, go, stop),
//                        Arrays.asList("woni", 2)),
//                Arguments.of("jun", Arrays.asList(stop, stop, go, stop),
//                        Arrays.asList("jun", 1)),
//                Arguments.of("jamie", Arrays.asList(stop, stop, stop, stop),
//                        Arrays.asList("jamie", 0))
//        );
//    }
//
//    @DisplayName("위치 값이 같은지 확인하기 테스트 - 같은 경우")
//    @MethodSource("generateMovement")
//    @ParameterizedTest
//    void isEqualPositionTest(List<MovementState> movementStates, int equalPosition) {
//        Car car = new Car("pobi");
//
//        for (MovementState movementState : movementStates) {
//            car.addPosition(movementState);
//        }
//
//        assertThat(car.isEqualPosition(equalPosition)).isTrue();
//    }
//
//    @DisplayName("위치 값이 같은지 확인하기 테스트 - 다른 경우")
//    @MethodSource("generateNotEqualMovement")
//    @ParameterizedTest
//    void isNotEqualPositionTest(List<MovementState> movementStates, int differentPosition) {
//        Car car = new Car("pobi");
//
//        for (MovementState movementState : movementStates) {
//            car.addPosition(movementState);
//        }
//
//        assertThat(car.isEqualPosition(differentPosition)).isFalse();
//    }
//
//    static Stream<Arguments> generateNotEqualMovement() {
//        MovementState go = MovementState.GO;
//        MovementState stop = MovementState.STOP;
//
//        return Stream.of(
//                Arguments.of(Arrays.asList(go, go, go, go), 1),
//                Arguments.of(Arrays.asList(go, stop, go, stop), 3),
//                Arguments.of(Arrays.asList(stop, stop, go, stop), 0),
//                Arguments.of(Arrays.asList(stop, stop, stop, stop), 4)
//        );
//    }
}

