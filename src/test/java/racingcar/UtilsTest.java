package racingcar;

import java.util.List;
import java.util.Arrays;
import java.util.Scanner;
import java.util.ArrayList;
import java.io.InputStream;
import java.io.ByteArrayInputStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;

public class UtilsTest {

    public static Scanner scan;

    public static InputStream userInputToStream(String input){
        return new ByteArrayInputStream(input.getBytes());
    }

    public static String getUserInputForTest(String userInput){
        InputStream in = userInputToStream(userInput);
        scan = new Scanner(in);
        return scan.nextLine();
    }

    @Test
    void 사용자_입력_검증(){
        String input = "Hello,world";
        String userInput = getUserInputForTest(input);
        assertThat(userInput).isEqualTo("Hello,world");
    }

    @Test
    void 사용자_입력_검증_split(){
        String input = "Hello,world";
        String[] result = Utils.inputNameSplit(",", input);
        assertArrayEquals(result, new String[]{"Hello", "world"});
    }

    @Test
    void 사용자_입력_검증_arrayToList(){
        String[] input = new String[]{"Hello", "world"};
        List<String> result = Utils.inputStrAryToNameList(input);
        assertIterableEquals(result, Arrays.asList("Hello", "world"));
    }

    @Test
    void 사용자_이름으로_PlayerList_생성_검증(){
        List<String> input = Arrays.asList("Hello", "world");
        List<Player> expect = new ArrayList<>();
        for(String name : input){
            expect.add(new Player(name));
        }
        assertIterableEquals(Utils.nameListToPlayerList(input), expect);
    }

    @Test
    void 이름_길이_검증(){
        boolean result = Utils.nameIsInRange("HelloWorld", 5);
        assertThat(result).isEqualTo(false);
        result = Utils.nameIsInRange("Hello", 5);
        assertThat(result).isEqualTo(true);
    }

    @Test
    void 중복된_이름_검증(){
        List<String> names = Arrays.asList("Hello", "Hello", "Hi");
        boolean result = Utils.nameIsDuplicate(names);
        assertThat(result).isEqualTo(true);

        names = Arrays.asList("Hi", "Hello", "World");
        result = Utils.nameIsDuplicate(names);
        assertThat(result).isEqualTo(false);
    }

    @Test
    void 이름_유효성_검증(){
        //중복 확인
        List<String> namesTest = Arrays.asList("Hello", "Hello");
        int maxRange = 5;
        assertThatThrownBy(()-> Utils.nameIsValid(namesTest, maxRange))
                .isInstanceOf(IllegalArgumentException.class);

        //길이 확인
        List<String> names = Arrays.asList("Chung", "myo");
        int maxRangeTest = 4;
        assertThatThrownBy(()->Utils.nameIsValid(names, maxRangeTest))
                .isInstanceOf(IllegalArgumentException.class);

        //정상 케이스 확인
        assertThatCode(()->Utils.nameIsValid(names, maxRange))
                .doesNotThrowAnyException();
    }

    @Test
    void 숫자_생성_검증(){
        int min = 0;
        int max = 9;
        assertThat(Utils.genNumberInRange(min, max)).isBetween(min, max);
    }
}
