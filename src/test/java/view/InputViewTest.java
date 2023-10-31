package view;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.Test;

class InputViewTest {
    static final InputView inputView = new InputView();

    @Test
    public void getNameList_하나의_이름만_입력할_때_정상작동(){
        String input = "aa";
        List<String> carName = inputView.getNameList();
        assertThat(carName.size()).isEqualTo(1);
        assertThat(carName).contains(input);
    }

    @Test
    public void getNameList_쉼표_사이에_띄어쓰기가_포함되었을_때_정상작동(){
        String input = "aa, bbbb, ccccc ";
        List<String> carName = inputView.getNameList();
        assertThat(carName.size()).isEqualTo(3);
        assertThat(carName).contains("aa");
        assertThat(carName).contains("bbbb");
        assertThat(carName).contains("ccccc");
    }

    @Test
    public void getNameList_이름_안에_띄어쓰기가_포함되었을_때_정상작동(){
        String input = "a  a, b b";
        List<String> carName = inputView.getNameList();
        assertThat(carName.size()).isEqualTo(2);
        assertThat(carName).contains("a  a");
        assertThat(carName).contains("b b");
    }
}