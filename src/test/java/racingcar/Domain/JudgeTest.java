package racingcar.Domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.Service.CarService;
import racingcar.Service.InputService;
import racingcar.Service.OutputService;

public class JudgeTest {
    OutputService outputService;
    Judge judge = new Judge();

    @BeforeEach
    public void init() {
        InputService inputService = new InputService();
        CarService car = new CarService();
        Judge judge1 = new Judge();

        outputService = new OutputService(car, inputService,judge1);
        inputService = outputService.getInputService();
        judge.setCarservice(car);
        judge.setInputService(inputService);


        String inputCarname = "pobi,woni,jun";
        inputService.inputCarname(inputCarname);
        inputService.SplitCarname(inputCarname);
        inputService.makeCarArray();
        car = outputService.getCarService();
        car.setGeneratedNum(5);

    }
    @Test
    @DisplayName("우승자 선출해서 반환하는 기능")
    public void judge1() {


        Assertions.assertThat(judge.judgeWinner()).contains("pobi");
    }
}
