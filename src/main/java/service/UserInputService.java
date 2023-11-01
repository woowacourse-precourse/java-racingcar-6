package service;

import camp.nextstep.edu.missionutils.Console;
import utils.TransformUtil;

import java.util.List;

public class UserInputService {
    public List<String> carName() {
        return TransformUtil.commasToList(Console.readLine());
    }
}
