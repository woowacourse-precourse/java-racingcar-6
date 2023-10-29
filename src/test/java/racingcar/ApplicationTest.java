//package racingcar;
//
//import camp.nextstep.edu.missionutils.test.NsTest;
//import org.junit.jupiter.api.Test;
//
//import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
//import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
//import static org.assertj.core.api.Assertions.assertThat;
//import static org.assertj.core.api.Assertions.assertThatThrownBy;
//
//class ApplicationTest extends NsTest {
//    private static final int MOVING_FORWARD = 4;
//    private static final int STOP = 3;
//
//    @Test
//    void 이름_5글자_이상_예외_처리() {
//        assertSimpleTest(() ->
//                assertThatThrownBy(() -> runException("pobi,javaji", "1"))
//                        //IllegalArgumentException가 리턴 되야 테스트 성공
//                        .isInstanceOf(IllegalArgumentException.class)
//        );
//    }
//    @Test
//    void 이름_공백_입력_예외_처리() {
//        assertSimpleTest(() ->
//                assertThatThrownBy(() -> runException("pobi, ", "1"))
//                        .isInstanceOf(IllegalArgumentException.class)
//        );
//    }
//}
//
//
////    void moveStop() {
////        assertRandomNumberInRangeTest(
////                () -> {
////                    run("pobi,woni", "1");
////                    assertThat(output()).contains("pobi : -", "woni : ", "최종 우승자 : pobi");
////                },
////                MOVING_FORWARD, STOP
////        );
////    }
////
////    @Test
////            //이름에_대한_예외_처리
////    void carNameException() {
////        assertSimpleTest(() ->
////                assertThatThrownBy(() -> runException("pobi,javaji", "1"))
////                        .isInstanceOf(IllegalArgumentException.class)
////        );
////    }
////
////    @Override
////    public void runMain() {
////        // 사용자 입력 대신에 파라미터로 전달하여 실행
////        Application.main(new String[]{"pobi,woni"});
////    }
////}