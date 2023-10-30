package validate;
import exceptional.ExceptionalCarNameRangeout;
import java.util.List;

public class ValidateNameInRange {

//    private new ExceptionalCarNameRangeout;
    private ValidateNameInRange(){
    }

    public static List<String> NameInRange(List<String> CarNames){

        for (int i=0; i < CarNames.size(); i++){
            if( 5< CarNames.get(i).length() ){
                ExceptionalCarNameRangeout.exception();
            }
        }
        return CarNames;
    }

}
