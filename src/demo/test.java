package demo;

import java.util.List;
import java.util.regex.Pattern;

public class test {

	public static void main(String[] args) {
		
		String s1 = "My String";
		String text = s1;
		System.out.println("text " + text);

		//String text2 = new String("My ");
		//text2 + new String("String");
		//System.out.println("text2 " + text2);
		
		String text3 = "My ";
		String s2 = "String";
		text3 = text3 + s2;
		System.out.println("text3 " + text3);
		
		String text4 = "My ";
		text4.concat("String");
		System.out.println("text4 " + text4);
		
		
		String field = "one (1), two (2), three (3)";
		Pattern pattern1 = Pattern.compile("[a-z]+|[()0-9]+");
		
		String[] split = pattern1.split(field);
		for(String string : split) {
			System.out.println(string);
		}
		
	}

}
