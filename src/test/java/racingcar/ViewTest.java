package racingcar;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
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

        assertThat(view.inputConsole()).isEqualTo(names);
    }

    @DisplayName("자동차의 현재 상태에 대해 출력하는 기능")
    @Test
    void printCurrentCarResult_자동차_상태출력(){
        Car car=new Car(new Name("ski"),new Position(3));
        View view=new View();

        String expected="ski : ---";
        PrintStream standardOut= System.out;
        ByteArrayOutputStream captor=new ByteArrayOutputStream();
        System.setOut(new PrintStream(captor));

        view.printCurrentCarResult(car);

        System.setOut(standardOut);
        String result=captor.toString().trim();

        assertThat(result).isEqualTo(expected);
    }
}
