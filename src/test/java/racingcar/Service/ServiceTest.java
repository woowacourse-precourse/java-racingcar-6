package racingcar.Service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.Domain.ProgressBoard;

class ServiceTest {
    private Service service;
    private ProgressBoard progressBoard;
    @BeforeEach
    void setService() {
        progressBoard = ProgressBoard.getInstance();
        service = new Service(progressBoard);
    }
    @Test
    void 입력_받은_만큼_자동차를_생성한다() {
        List<String> cars = List.of("test1","test2","test3");

        service.registerCars(cars);

        Assertions.assertThat(progressBoard.getParticipants().size()).isEqualTo(3);
    }

    @Test
    void 자동차를_전진시킨다() {
        List<String> cars = List.of("test1","test2","test3");
        service.registerCars(cars);

        progressBoard.moveForward("test1");
        progressBoard.moveForward("test3");

        Assertions.assertThat(progressBoard.progressOf("test1")).isEqualTo("-");
        Assertions.assertThat(progressBoard.progressOf("test2")).isEqualTo("");
        Assertions.assertThat(progressBoard.progressOf("test3")).isEqualTo("-");
    }

    @Test
    void 우승자를_선정한다() {
        List<String> cars = List.of("test1","test2","test3");
        service.registerCars(cars);

        progressBoard.moveForward("test1");
        progressBoard.moveForward("test1");
        progressBoard.moveForward("test2");
        progressBoard.moveForward("test2");

        Assertions.assertThat(service.getWinners()).contains("test1","test2");
    }

}