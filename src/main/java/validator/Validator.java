package validator;

public class Validator {
    String regExp = "^[1-9]*$";

    public void cheackLengthName(List<String> names) {
        for(String name : names) {
            if(name.length() > 5) {
                System.out.println("에러 throw");
            }
        }
    }

    public void checkTryNumber(String tryNumber) {
        if(!(tryNumber.matches(regExp))) {
            System.out.println("에러 throw");
        }
    }
}
