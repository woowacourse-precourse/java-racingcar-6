package racingcar.service;

public class RaceCountValidationService {

    public void raceCountValidation(String raceCountInString) {
        int raceCount = stringToInt(raceCountInString);
        validationFinalRaceCount(raceCount);
    }

    private int stringToInt(String raceCountInString) {
        try {
            return Integer.parseInt(raceCountInString);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("1~2,147,483,647 사이의 숫자로 입력해주세요.");
        }
    }

    private void validationFinalRaceCount(int raceCount) {
        if (raceCount < 1) {
            throw new IllegalArgumentException("1~2,147,483,647 사이의 숫자로 입력해주세요.");
        }
    }

}
