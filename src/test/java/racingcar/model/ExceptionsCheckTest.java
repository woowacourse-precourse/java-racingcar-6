package racingcar.model;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ExceptionsCheckTest{

    ExceptionsCheck exceptionsCheck = new ExceptionsCheck();

    // Car

    @Test
    void inputCarIsEmpty() {

        String input = null;

        assertThrows(IllegalArgumentException.class,()->exceptionsCheck.inputCarIsEmpty(input),
                ()-> "입력_값이_없다면_예외처리_되어야_합니다.");
    }

    @Test
    void ghostCarExist() {

        String input = "abc,,ab,";

        assertThrows(IllegalArgumentException.class,()->exceptionsCheck.ghostCarExist(input),
                ()-> "자동차_이름이_공백이면_예외처리_되어야_합니다.");
    }

    @Test
    void passCountInputCarString() {

        int falseCount = 0;
        boolean bool1 = false;
        boolean bool2 = false;


        int testInt = exceptionsCheck.passCountInputCarString(bool1,bool2);

        if(!bool1)
            falseCount++;
        if(!bool2)
            falseCount++;
        int expectInt = falseCount;


        assertEquals(expectInt,testInt,()->"passCount_와_return_값이_일치하지_않습니다.");
    }

    @Test
    void passedCheckInputCarString() {

        String input = "통과";
        int passCount = 2;


        String testString = exceptionsCheck.passedCheckInputCarString(passCount,input);
        String expectedString = "통과";


        assertEquals(expectedString,testString,()-> "String이_동일하게_반환되어야_합니다.");
    }

    @Test
    void carNameLengthOvercome() {

        List<String> testList = new ArrayList<>(List.of("dfef", "teetm" , "ejejddd"));

        assertThrows(IllegalArgumentException.class, ()->exceptionsCheck.carNameLengthOvercome(testList),
                ()-> "자동차_이름의_길이가_5_이상이면_예외_처리_되어야_합니다.");
    }

    @Test
    void sameCarNameExist() {

        List<String> testList = new ArrayList<>(List.of("car1", "car2" , "car3", "car2"));

        assertThrows(IllegalArgumentException.class, () -> exceptionsCheck.sameCarNameExist(testList),
                () -> "동일한_차_이름이_존재_한다면_예외_처리_되어야_합니다.");
    }

    @Test
    void testPassCountAsCar() {

        int falseCount = 0;
        boolean bool1 = false;
        boolean bool2 = false;


        int testInt = exceptionsCheck.testPassCountAsCar(bool1,bool2);

        if(!bool1)
            falseCount++;
        if(!bool2)
            falseCount++;
        int expectInt = falseCount;


        assertEquals(expectInt, testInt, () -> "passCount_와_return_값이_일치하지_않습니다.");
    }

    @Test
    void passedCheckCarList() {

        List<String> passedList = new ArrayList<>(List.of("통과1", "통과2", "통과3"));
        int passCount = 2;


        List<String> testList = exceptionsCheck.passedCheckCarList(passCount,passedList);
        List<String> expectedList = new ArrayList<>(List.of("통과1", "통과2", "통과3"));


        assertEquals(expectedList,testList,()->"List가_동일하게_반환되어야_합니다.");
    }

    // Loop

    @Test
    void inputLoopIsEmpty() {

        String input = null;

        assertThrows(IllegalArgumentException.class,()->exceptionsCheck.inputLoopIsEmpty(input),
                ()->"입력_값이_없다면_예외처리_되어야_합니다.");
    }

    @Test
    void inputLoopIsNotInteger() {

        String input = "122a";

        assertThrows(IllegalArgumentException.class,()->exceptionsCheck.inputLoopIsNotInteger(input),
                ()-> "문자열에_정수가_아닌_문자가_섞여_있을_시_예외처리_되어야_합니다.");
    }

    @Test
    void inputLoopIsZero () {

        String input = "0";

        assertThrows(IllegalArgumentException.class,()->exceptionsCheck.inputLoopIsZero(input),
                () -> " \"0\"_이_입력_되었을_시_예외처리_되어야_합니다.");

    }

    @Test
    void testPassCountAsLoop() {

        int falseCount = 0;
        boolean bool1 = false;
        boolean bool2 = false;
        boolean bool3 = false;


        int testInt = exceptionsCheck.testPassCountAsLoop(bool1,bool2,bool3);

        if(!bool1)
            falseCount++;
        if(!bool2)
            falseCount++;
        if(!bool3)
            falseCount++;
        int expectInt = falseCount;


        assertEquals(expectInt, testInt, () -> "passCount_와_return_값이_일치하지_않습니다.");
    }

    @Test
    void passedCheckLoopString() {

        String passedLoop = "123456";
        int passCount = 3;


        String testString = exceptionsCheck.passedCheckLoopString(passCount,passedLoop);
        String expectedString = "123456";


        assertEquals(expectedString,testString,()->"String이_동일하게_반환되어야_합니다.");
    }
}