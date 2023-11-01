package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.HashSet;
import org.junit.jupiter.api.Test;

class UserInputTest {
    @Test
    void testIsStringEmptyWithNull() {
        // Given
        UserInput userInput = new UserInput("test");

        // When
        boolean result = userInput.isStringEmpty(null);

        // Then
        assertTrue(result, "Input value cannot be blank.");
    }

    @Test
    public void testIsStringEmptyWithBlankString() {
        // Given
        UserInput userInput = new UserInput("test");

        // When
        boolean result = userInput.isStringEmpty("");

        // Then
        assertTrue(result, "Input value cannot be blank.");
    }

    @Test
    public void testIsStringEmptyWithWhiteSpaceString() {
        // Given
        UserInput userInput = new UserInput("test");

        // When
        boolean result = userInput.isStringEmpty(" ");

        // Then
        assertTrue(result, "Input value cannot be blank.");
    }

    @Test
    public void testIsStringEmptyWithNonEmptyString() {
        // Given
        UserInput userInput = new UserInput("test");

        // When
        boolean result = userInput.isStringEmpty("car1,car2");

        // Then
        assertFalse(result);
    }

    @Test
    public void testConvertStringToArraySplitByComma() {
        // Given
        UserInput userInput = new UserInput("car1,car2,car3");

        // When
        String[] result = userInput.convertStringToArraySplitByComma("car1,car2,car3");

        // Then
        assertThat(result).containsExactly("car1", "car2", "car3");
    }

    @Test
    public void testConvertStringToArraySplitByComma_SingleValue() {
        // Given
        UserInput userInput = new UserInput("car1");

        // When
        String[] result = userInput.convertStringToArraySplitByComma("car1");

        // Then
        assertThat(result).containsExactly("car1");
    }

    @Test
    public void testIsContainComma_ArrayLengthGreaterThanOne() {
        // Given
        UserInput userInput = new UserInput("car1,car2");

        // When
        boolean result = userInput.isContainComma(2);

        // Then
        assertThat(result).isTrue();
    }

    @Test
    public void testIsContainComma_ArrayLengthEqualsOne() {
        // Given
        UserInput userInput = new UserInput("car1");

        // When
        boolean result = userInput.isContainComma(1);

        // Then
        assertThat(result).isFalse();
    }

    @Test
    public void testIsContainComma_ArrayLengthZero() {
        // Given
        UserInput userInput = new UserInput("");

        // When
        boolean result = userInput.isContainComma(0);

        // Then
        assertThat(result).isFalse();
    }

    @Test
    public void testCheckEachCharacter_NameLengthExceedsMax() {
        // Given
        String tooLongName = "toolongname";
        UserInput userInput = new UserInput(tooLongName);

        // When & Then
        assertThatThrownBy(() -> userInput.checkEachCharacter(tooLongName))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("The length of the name must be 5 or less.");
    }

    @Test
    public void testCheckEachCharacter_ValidNameLength() {
        // Given
        String validName = "car1";
        UserInput userInput = new UserInput(validName);

        // When & Then
        userInput.checkEachCharacter(validName);
    }

    @Test
    public void testCheckEachCharacter_InvalidCharactersInName() {
        // Given
        String invalidName = "car@1";
        UserInput userInput = new UserInput(invalidName);

        // When & Then
        assertThatThrownBy(() -> userInput.checkEachCharacter(invalidName))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Only English letters, numbers, and '-' symbol are allowed in the name.");
    }

    @Test
    public void testCheckEachCharacter_ValidCharactersInName() {
        // Given
        String validName = "car-1";
        UserInput userInput = new UserInput(validName);

        // When & Then
        userInput.checkEachCharacter(validName);
    }

    @Test
    public void testIsAlphabet_ValidAlphabets() {
        // Given
        UserInput userInput = new UserInput("carName");

        // When
        boolean resultUppercase = userInput.isAlphabet('A');
        boolean resultLowercase = userInput.isAlphabet('z');

        // Then
        assertTrue(resultUppercase);
        assertTrue(resultLowercase);
    }

    @Test
    public void testIsAlphabet_InvalidNonAlphabets() {
        // Given
        UserInput userInput = new UserInput("123");

        // When
        boolean resultNumber = userInput.isAlphabet('1');
        boolean resultSymbol = userInput.isAlphabet('@');

        // Then
        assertFalse(resultNumber);
        assertFalse(resultSymbol);
    }

    @Test
    public void testIsNumber_ValidNumbers() {
        // Given
        UserInput userInput = new UserInput("test");

        // When
        boolean resultNumber = userInput.isNumber('5');

        // Then
        assertTrue(resultNumber);
    }

    @Test
    public void testIsNumber_InvalidNonNumbers() {
        // Given
        UserInput userInput = new UserInput("test");

        // When
        boolean resultLetter = userInput.isNumber('a');
        boolean resultSymbol = userInput.isNumber('&');

        // Then
        assertFalse(resultLetter);
        assertFalse(resultSymbol);
    }

    @Test
    public void testIsHyphenSign_ValidHyphen() {
        // Given
        UserInput userInput = new UserInput("test");

        // When
        boolean result = userInput.isHyphenSign('-');

        // Then
        assertTrue(result);
    }

    @Test
    public void testIsHyphenSign_InvalidCharacters() {
        // Given
        UserInput userInput = new UserInput("test");

        // When
        boolean resultNumber = userInput.isHyphenSign('5');
        boolean resultLetter = userInput.isHyphenSign('a');

        // Then
        assertFalse(resultNumber);
        assertFalse(resultLetter);
    }

    @Test
    public void testCheckEachCharacter_ValidCharacters() {
        // Given
        UserInput userInput = new UserInput("car-1");

        // When & Then
        assertDoesNotThrow(() -> userInput.checkEachCharacter("car-1"));
    }

    @Test
    public void testCheckEachCharacter_InvalidCharacters() {
        // Given
        UserInput userInput = new UserInput("car#1");

        // When & Then
        assertThatThrownBy(() -> userInput.checkEachCharacter("car#1")).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Only English letters, numbers, and '-' symbol are allowed in the name.");
    }

    @Test
    public void testIsOnlyNumbers_OnlyNumbers() {
        // Given
        UserInput userInput = new UserInput("test");

        // When
        boolean result = userInput.isOnlyNumbers("12");

        // Then
        assertTrue(result);
    }

    @Test
    public void testIsOnlyNumbers_NotOnlyNumbers() {
        // Given
        UserInput userInput = new UserInput("test");

        // When
        boolean result = userInput.isOnlyNumbers("a5");

        // Then
        assertFalse(result);
    }

    @Test
    public void testIsZero_True() {
        // Given
        UserInput userInput = new UserInput("test");

        // When
        boolean result = userInput.isZero("0");

        // Then
        assertTrue(result);
    }

    @Test
    public void testIsZero_False() {
        // Given
        UserInput userInput = new UserInput("test");

        // When
        boolean result = userInput.isZero("123");

        // Then
        assertFalse(result);
    }

    @Test
    public void testIsHighestDigitZero_True() {
        // Given
        UserInput userInput = new UserInput("test");

        // When
        boolean result = userInput.isHighestDigitZero("0123");

        // Then
        assertTrue(result);
    }

    @Test
    public void testIsHighestDigitZero_False() {
        // Given
        UserInput userInput = new UserInput("test");

        // When
        boolean result = userInput.isHighestDigitZero("1230");

        // Then
        assertFalse(result);
    }

    @Test
    public void testCheckAttemptsNumberValidity_ValidInput() {
        // Given
        UserInput userInput = new UserInput("test");
        userInput.setAttemptsNumber("3");

        // When & Then
        assertDoesNotThrow(userInput::checkAttempsNumberValidity);
    }

    @Test
    public void testCheckAttemptsNumberValidity_Zero() {
        // Given
        UserInput userInput = new UserInput("test");
        userInput.setAttemptsNumber("0");

        // When & Then
        assertThrows(IllegalArgumentException.class, userInput::checkAttempsNumberValidity,
                "It cannot be 0.");
    }

    @Test
    public void testCheckAttemptsNumberValidity_NonNumeric() {
        // Given
        UserInput userInput = new UserInput("test");
        userInput.setAttemptsNumber("-12");

        // When & Then
        assertThrows(IllegalArgumentException.class, userInput::checkAttempsNumberValidity,
                "Non-numeric values cannot be included, and therefore, negative numbers and decimals are also not allowed.");
    }

    @Test
    public void testCheckAttemptsNumberValidity_LeadingZero() {
        // Given
        UserInput userInput = new UserInput("test");
        userInput.setAttemptsNumber("01");

        // When & Then
        assertThrows(IllegalArgumentException.class, userInput::checkAttempsNumberValidity,
                "The number in the highest digit cannot be 0.");
    }

    @Test
    public void testTransferToHashSetFrom() {
        // Given
        UserInput userInput = new UserInput("car1,car2,car3");
        String[] carArray = {"car1", "car2", "car3"};

        // When
        userInput.transferTohashSetFrom(carArray);

        // Then
        HashSet<String> carHashSet = userInput.getCarHashSet();

        assertTrue(carHashSet.contains("car1"));
        assertTrue(carHashSet.contains("car2"));
        assertTrue(carHashSet.contains("car3"));
    }

    @Test
    public void testContainsDuplicates_NoDuplicates() {
        // Given
        UserInput userInput = new UserInput("car1,car2,car3");
        String[] carArray = {"car1", "car2", "car3"};

        userInput.setCarArray(carArray);
        userInput.transferTohashSetFrom(carArray);

        // When
        boolean result = userInput.containsDuplicates();

        // Then
        assertFalse(result);
    }

    @Test
    public void testContainsDuplicates_Duplicates() {
        // Given
        UserInput userInput = new UserInput("car1,car2,car1");
        String[] carArray = {"car1", "car2", "car1"};
        userInput.setCarArray(carArray);
        userInput.transferTohashSetFrom(carArray);

        // When
        boolean result = userInput.containsDuplicates();

        // Then
        assertTrue(result);
    }

    @Test
    public void testCheckNameOfCarsValidity_ValidNames() {
        // Given
        UserInput userInput = new UserInput("car1,car2,car3");

        // When & Then
        assertDoesNotThrow(() -> userInput.checkNameOfCarsValidity());
    }

    @Test
    public void testCheckNameOfCarsValidity_DuplicatedNames() {
        // Given
        UserInput userInput = new UserInput("car1,car2,car1");

        // When & Then
        assertThrows(IllegalArgumentException.class, userInput::checkNameOfCarsValidity,
                "Car names cannot be duplicated.");
    }
}