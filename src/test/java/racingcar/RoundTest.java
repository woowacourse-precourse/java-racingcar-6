package study;

import org.junit.jupiter.api.Test;
import racingcar.util.Round;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class RoundTest {
    @Test
    void Increase_테스트() {
        Round round = new Round(6,0);
        int result1= round.Increase();
        int result2= round.Increase();
        int result3= round.Increase();
        int result4= round.Increase();
        int result5= round.Increase();
        int result6= round.Increase();
        assertEquals(result1,1);
        assertEquals(result2,2);
        assertEquals(result3,3);
        assertEquals(result4,4);
        assertEquals(result5,5);
        assertEquals(result6,6);
        assertEquals(round.Get_Round_index(),6);
    }

    @Test
    void Get_Round_index_테스트() {
        Round round1 = new Round(6,3);
        Round round2 = new Round(6,2);
        Round round3 = new Round(6,1);
        assertEquals(round1.Get_Round_index(),3);
        assertEquals(round2.Get_Round_index(),2);
        assertEquals(round3.Get_Round_index(),1);
    }

    @Test
    void Get_Round_Remaining_테스트() {
        Round round1 = new Round(6,3);
        Round round2 = new Round(6,2);
        Round round3 = new Round(6,1);
        assertEquals(round1.Get_Round_Remaining(),3);
        assertEquals(round2.Get_Round_Remaining(),4);
        assertEquals(round3.Get_Round_Remaining(),5);
    }
}
