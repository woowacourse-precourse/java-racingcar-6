package view;

import camp.nextstep.edu.missionutils.Console;

public class Input_view {
    public String getInput(String type){
        String input_text = Console.readLine();
        switch(type){
            case "number":
                try{
                    Integer.parseInt(input_text);
                }
                catch (NumberFormatException ex){
                    Output_view.Error();
                }
            case "text":
            default:
                break;
        }
        return input_text;
    }
}
