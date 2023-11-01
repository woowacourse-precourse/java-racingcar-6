package racingcar.IO;

public class ManageException {
    public void nameCount(String[] names){
        for (int i = 0; i < names.length; i++){
            if (5 < names[i].length()) {
                throw new IllegalArgumentException();
            }
        }
    }

    public void checkType(String given) {
//        try{
//            int trials = Integer.parseInt(given);
//        }catch (NumberFormatException e){
//            throw new IllegalArgumentException();
//        }
    }

    public void tryCount(int count) {
        if (count < 1) {
            throw new IllegalArgumentException();
        }
    }
}
