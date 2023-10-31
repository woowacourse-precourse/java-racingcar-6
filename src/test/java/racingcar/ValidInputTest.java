package racingcar;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ValidInputTest {

    @Test
    void isValidString() {
    }

    @Test
    void hasComma_문자열에_Comma_존재_여부_확인() {
        String[] inputs = {"stringstringstring", "stringstr,ingstring", ",stringstringstring", "stringstringstring,"};
        Boolean[] expectedOutputs = {false, true, true, true};
        ArrayList<Boolean> outputsList = new ArrayList<>();
        for(String str : inputs) {
            outputsList.add(ValidInput.hasComma(str));
        }
        Boolean[] Outputs = outputsList.toArray(new Boolean[0]);
        assertArrayEquals(expectedOutputs, Outputs);
    }

    @Test
    void hasDoubleComma_문자열에_CommaComma_존재_여부_확인() {
        String[] inputs = {"stringstringstring", "stringstr,,ingstring", ",,stringstringstring", "stringstringstring,,"};
        Boolean[] expectedOutputs = {false, true, true, true};
        ArrayList<Boolean> outputsList = new ArrayList<>();
        for(String str : inputs) {
            outputsList.add(ValidInput.hasDoubleComma(str));
        }
        Boolean[] Outputs = outputsList.toArray(new Boolean[0]);
        assertArrayEquals(expectedOutputs, Outputs);
    }

    @Test
    void startsOrEndsWithComma_문자열이_Comma로_시작하거나_끝나는_지_확인() {
        String[] inputs = {"stringstringstring", "stringstr,,ingstring", ",stringstringstring", "stringstringstring,,"};
        Boolean[] expectedOutputs = {false, false, true, true};
        ArrayList<Boolean> outputsList = new ArrayList<>();
        for(String str : inputs) {
            outputsList.add(ValidInput.startsOrEndsWithComma(str));
        }
        Boolean[] Outputs = outputsList.toArray(new Boolean[0]);
        assertArrayEquals(expectedOutputs, Outputs);
    }

    @Test
    void isValidNames() {
    }

    @Test
    void isNameLengthLessThanOrEqual5() {
        String[] inputs1 = {"a", "bb", "ccc", "dddd", "eeeee", "f f"};
        String[] inputs2 = {"a", "bb", "ccc", "dddd", "eeeee", "f f", "gggggg"};
        Boolean[] expectedOutputs = {true, false};
        ArrayList<Boolean> outputsList = new ArrayList<>();
        outputsList.add(ValidInput.isNameLengthLessThanOrEqual5(Arrays.asList(inputs1)));
        outputsList.add(ValidInput.isNameLengthLessThanOrEqual5(Arrays.asList(inputs2)));
        Boolean[] Outputs = outputsList.toArray(new Boolean[0]);
        assertArrayEquals(expectedOutputs, Outputs);
    }

    @Test
    void hasDuplicateNames() {
        String[] inputs1 = {"a", "aa", "ccc", "dddd", "eeeee"};
        String[] inputs2 = {"a", "a", "ccc", "dddd"};
        Boolean[] expectedOutputs = {false, true};
        ArrayList<Boolean> outputsList = new ArrayList<>();
        outputsList.add(ValidInput.hasDuplicateNames(Arrays.asList(inputs1)));
        outputsList.add(ValidInput.hasDuplicateNames(Arrays.asList(inputs2)));
        Boolean[] Outputs = outputsList.toArray(new Boolean[0]);
        assertArrayEquals(expectedOutputs, Outputs);
    }
}