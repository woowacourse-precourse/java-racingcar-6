package racingcar.util;

public class Verify {
    public static String[] inputVerify(String input) throws IllegalArgumentException{
        String[] names = input.split(",");
        for(int i=0; i<names.length;i++){
            if(names[i].length() > 5) {
                throw new IllegalArgumentException();
            }
        }
        return names;
    }
}
