//package racingcar.domain;
//
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//
//import static org.assertj.core.api.Assertions.assertThat;
//
//class CarTest {
//    private Car car;
//    private static final String name = "jun";
//    @BeforeEach
//    void setUp(){
//        car = new Car(name);
//    }
//    private static final int DEPART_NUM = 4;
//    private static final int CANNOT_GO = 3;
//
//    @Test
//    void 수가_랜덤_중_4_이상_일_때_직진(){
//        car.goForward(DEPART_NUM);
//        assertThat(car.getForward()).isEqualTo(1);
//    }
//
//    @Test
//    void 수가_랜덤_중_4가_안_될_때(){
//        car.goForward(CANNOT_GO);
//        assertThat(car.getForward()).isEqualTo(0);
//    }
//
//
//}