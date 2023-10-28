package racingcar.validator;

import net.bytebuddy.pool.TypePool.Resolution.Illegal;
import java.util.regex.Pattern;

public class InputValidation {
    public static void validNameFormat(String name) throws IllegalArgumentException{
        String pattern = "^(?:[^,]+,)*[^,]+$";
        if (!Pattern.matches(pattern, name))    throw new IllegalArgumentException("입력 형식이 옳지 않습니다.");
    }
    public static void validNameLength(String name) throws IllegalArgumentException{
        if (name.length() > 5) throw new IllegalArgumentException("이름의 길이는 5자리를 넘을 수 없습니다.");
    }
}
