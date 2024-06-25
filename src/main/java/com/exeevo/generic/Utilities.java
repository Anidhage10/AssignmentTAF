package com.exeevo.generic;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Utilities {

	
	public Utilities() {}
	
	/**
	 * getDataUsingRegex - method is used for to get the string value as per the regular expression
	 * @param regex
	 * @param striPhoneDetails
	 * @return
	 */
	public String getDataUsingRegex(String regex ,String striPhoneDetails) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(striPhoneDetails);
        if (matcher.find()) {
            //System.out.println(matcher.group());
            return matcher.group().toString();
        } else {
            System.out.println("No match found");
            return "";
        }
}

	
}
