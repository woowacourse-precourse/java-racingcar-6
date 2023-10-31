package mytest;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import racingcar.model.Car;
import racingcar.utils.GetWinner;

public class ResultTest {
    @DisplayName("우승자 여부 확인 테스트")
    @Test
    void 우승자_구하는_태스트() {
        //given
        List<racingcar.model.Car> Users = new ArrayList<>();
        Users.add(new Car("jeong"));
        Users.add(new Car("min"));
        //when
        Users.get(1).forward();
        //then
        List<String> result = GetWinner.winnerList(Users);
        assertThat(result).contains("min");
    }
}
