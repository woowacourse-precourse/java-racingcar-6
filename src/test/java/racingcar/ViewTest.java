package racingcar;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ViewTest {
    @DisplayName("콘솔에서 사용자에게 이름들을 입력받는 기능")
    @Test
    void inputNames_콘솔로_이름들_입력(){
        String names="pobi,woni,jun,james,timmy,ski";
        InputStream in=new ByteArrayInputStream(names.getBytes());
        System.setIn(in);

        View view=new View();

        assertThat(view.inputNames()).isEqualTo(names);
    }
}
