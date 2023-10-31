package racingcar.view;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class InputViewTest {

    @DisplayName("입력 받은 이름들을 (,) 기준으로 나눠서 리스트로 저장")
    @Test
    void splitNames(){
        //given
        InputView inputView = new InputView();
        String names = "soso,bobo,coco";

        //when
        List<String> nameList = inputView.splitNames(names);

        //then
        assertThat(nameList).hasSize(3)
                .containsExactly("soso", "bobo", "coco");
    }
  
}