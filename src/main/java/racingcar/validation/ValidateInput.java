package racingcar.validation;

import racingcar.exception.InvalidApplicantCarListException;
import racingcar.exception.InvalidCarNameLengthException;
import racingcar.exception.InvalidRaceCountException;

public class ValidateInput {
    public void validateInPutApplicantCarList(String userEnteredApplicantCarList) {
        if (userEnteredApplicantCarList.isEmpty()) {
            throw new InvalidApplicantCarListException("잘못된 지원 형식입니다. (공백을 입력하실 수 없습니다.)");
        }

        String[] ApplicantCarNameList = userEnteredApplicantCarList.split(",");
        if (ApplicantCarNameList.length < 2) {
            throw new InvalidApplicantCarListException("잘못된 지원 형식입니다. (최소 두 대의 자동차를 입력해야 합니다.)");
        }
    }

    public void validateInputCarNameLength(String carName) {
        if (carName.length() > 5) {
            throw new InvalidCarNameLengthException("잘못된 지원 형식입니다. (신청할 자동차 이름은 5글자 이하여야 합니다)");
        }
    }

    public void validateInputRaceCount(int userEnteredRaceCount) {
        if (userEnteredRaceCount < 1) {
            throw new InvalidRaceCountException("경주 횟수는 1회 이상이어야 합니다.");
        }
    }
}
