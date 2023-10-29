package validator;

import java.util.List;

public class Validator {
    String regExp = "^[1-9]*$";

    public void checkLengthName(List<String> names) {
        for(String name : names) {//공백은 length 길이에 포함
            if(name.length() > 5) {
                System.out.println("에러 throw" + name);
            }
        }
    }

    public int checkTryNumber(String tryNumber) {
        if(!(tryNumber.matches(regExp))) {
            System.out.println("에러 throw");
        }
        return Integer.parseInt(tryNumber);
    }
}
