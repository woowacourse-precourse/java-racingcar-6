package racingcar.domain;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class RacingTest {
    @Test
    public void startRacing_turn만큼_이동하기() throws Exception {
        //given

        //when

        //then
    }
    @Test
    public void getWinner_한명의_우승자() throws Exception {
        //given

        //when

        //then
    }
    @Test
    public void getWinner_여러명의_우승자() throws Exception {
        //given

        //when

        //then
    }
    @Test
    public void validateCarInputs_이름이_5자_이하_체크() throws Exception {
        //given
        List<Car> carList = new ArrayList<>();
        carList.add(new Car("7figure"));

        //when

        //then
    }
    @Test
    public void validateCarInputs_중복_이름_체크() throws Exception {
        //given

        //when

        //then
    }
}