package racingcar.controller;

import org.junit.jupiter.api.Test;
import racingcar.model.CarDto;
import racingcar.model.WinnerDto;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class JudgementTest {

    @Test
    public void 우승자_한명_일때_판단_테스트(){
        List<CarDto> carInformationList = new ArrayList<>();
        carInformationList.add(new CarDto("jun",3));
        carInformationList.add(new CarDto("sang",5));

        Judgement judgement = new Judgement();
        WinnerDto result = judgement.judgeWinner(carInformationList);

        //검증
        List<String> expectedWinner = new ArrayList<>();
        expectedWinner.add("sang");

        assertThat(result.getWinner()).isEqualTo(expectedWinner);
    }

    @Test
    public void 우승자_두명_이상_일때_판단_테스트(){
        List<CarDto> carInformationList = new ArrayList<>();
        carInformationList.add(new CarDto("jun",3));
        carInformationList.add(new CarDto("sang",5));
        carInformationList.add(new CarDto("sam",5));

        Judgement judgement = new Judgement();
        WinnerDto result = judgement.judgeWinner(carInformationList);

        //검증
        List<String> expectedWinner = new ArrayList<>();
        expectedWinner.add("sang");
        expectedWinner.add("sam");

        assertThat(result.getWinner()).isEqualTo(expectedWinner);
    }
}
