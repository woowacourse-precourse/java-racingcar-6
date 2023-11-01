package racingcar.service;

import camp.nextstep.edu.missionutils.Randoms;

import static racingcar.constant.NumberConstant.MAX_NUMBER;
import static racingcar.constant.NumberConstant.MIN_NUMBER;

public class NumberGenerateServiceImpl implements NumberGenerateService{
    @Override
    public int randomNumber() {
        int randomNumber = Randoms.pickNumberInRange(MIN_NUMBER.getNumber(), MAX_NUMBER.getNumber());
        return randomNumber;
    }
}
