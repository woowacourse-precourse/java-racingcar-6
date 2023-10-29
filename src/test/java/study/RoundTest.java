package study;

import org.junit.jupiter.api.Test;
import racingcar.util.Round;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class RoundTest {
    @Test
    void Increase() {
        Round round = new Round(6,0);
        int result1= round.Increase();
        int result2= round.Increase();
        int result3= round.Increase();
        int result4= round.Increase();
        int result5= round.Increase();
        int result6= round.Increase();
        assertThat(result1).isEqualTo(1);
        assertThat(result2).isEqualTo(2);
        assertThat(result3).isEqualTo(3);
        assertThat(result4).isEqualTo(4);
        assertThat(result5).isEqualTo(5);
        assertThat(result6).isEqualTo(6);
        assertThat(round.Get_Round_index()).isEqualTo(6);
    }

    @Test
    void Get_Round_index_테스트() {
        Round round1 = new Round(6,3);
        Round round2 = new Round(6,2);
        Round round3 = new Round(6,1);
        assertThat(round1.Get_Round_index()).isEqualTo(3);
        assertThat(round2.Get_Round_index()).isEqualTo(2);
        assertThat(round3.Get_Round_index()).isEqualTo(1);
    }

    @Test
    void Get_Round_Remaining() {
        Round round1 = new Round(6,3);
        Round round2 = new Round(6,2);
        Round round3 = new Round(6,1);
        assertThat(round1.Get_Round_Remaining()).isEqualTo(3);
        assertThat(round2.Get_Round_Remaining()).isEqualTo(4);
        assertThat(round3.Get_Round_Remaining()).isEqualTo(5);
    }
}
