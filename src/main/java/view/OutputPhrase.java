package view;

import model.Constants;

public class OutputPhrase {

    public void outputProgressMessage(String name, String dash) {
        System.out.println(name+" : "+dash);
    }

    public void outputRunOnce(){
        System.out.println();
    }

    public void outputFinalMessage(String winner){
        System.out.println(Constants.FINAL_OUTPUT_MESSAGE+winner);
    }
}
