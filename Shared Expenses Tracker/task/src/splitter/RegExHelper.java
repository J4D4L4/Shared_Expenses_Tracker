package splitter;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegExHelper {

    public static boolean isUpperCase(String input){
        if(input.equals(input.toUpperCase())){
            return true;
        }
        return false;

    }

    public static boolean isDate(String input){

        String nameStringPattern = "\\d\\d\\d\\d.\\d\\d.\\d\\d";
        Pattern namePattern = Pattern.compile(nameStringPattern,Pattern.CASE_INSENSITIVE);
        Matcher matcher = namePattern.matcher(input);
        if(input.length()<=1)
            return false;
        return matcher.find();
    }

}
