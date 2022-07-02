package odevJavacamp;

import java.util.HashMap;

public class OSGIservice2 {

	static HashMap<String, Integer> numbers = new HashMap<String, Integer>();
	static HashMap<String, Integer> onumbers = new HashMap<String, Integer>();
	static HashMap<String, Integer> tnumbers = new HashMap<String, Integer>();

	static HashMap<String, Integer> numbersTR = new HashMap<String, Integer>();
	static HashMap<String, Integer> onumbersTR = new HashMap<String, Integer>();
	static HashMap<String, Integer> tnumbersTR = new HashMap<String, Integer>();

	static {
		numbers.put("zero", 0);
		numbers.put("one", 1);
		numbers.put("two", 2);
		numbers.put("three", 3);
		numbers.put("four", 4);
		numbers.put("five", 5);
		numbers.put("six", 6);
		numbers.put("seven", 7);
		numbers.put("eight", 8);
		numbers.put("nine", 9);
		numbers.put("ten", 10);
		numbers.put("eleven", 11);
		numbers.put("twelve", 12);
		numbers.put("thirteen", 13);
		numbers.put("fourteen", 14);
		numbers.put("fifteen", 15);
		numbers.put("sixteen", 16);
		numbers.put("seventeen", 17);
		numbers.put("eighteen", 18);
		numbers.put("nineteen", 19);

		tnumbers.put("twenty", 20);
		tnumbers.put("thirty", 30);
		tnumbers.put("fourty", 40);
		tnumbers.put("fifty", 50);
		tnumbers.put("sixty", 60);
		tnumbers.put("seventy", 70);
		tnumbers.put("eighty", 80);
		tnumbers.put("ninety", 90);

		onumbers.put("hundred", 100);
		onumbers.put("thousand", 1000);
		onumbers.put("million", 1000000);
		onumbers.put("billion", 1000000000);

		// TR
		numbersTR.put("sıfır", 0);
		numbersTR.put("bir", 1);
		numbersTR.put("iki", 2);
		numbersTR.put("üç", 3);
		numbersTR.put("dört", 4);
		numbersTR.put("beş", 5);
		numbersTR.put("altı", 6);
		numbersTR.put("yedi", 7);
		numbersTR.put("sekiz", 8);
		numbersTR.put("dokuz", 9);
		numbersTR.put("on", 10);

		tnumbersTR.put("yirmi", 20);
		tnumbersTR.put("otuz", 30);
		tnumbersTR.put("kırk", 40);
		tnumbersTR.put("elli", 50);
		tnumbersTR.put("altmış", 60);
		tnumbersTR.put("yetmiş", 70);
		tnumbersTR.put("seksen", 80);
		tnumbersTR.put("doksan", 90);

		onumbersTR.put("yüz", 100);
		onumbersTR.put("bin", 1000);
		onumbersTR.put("milyon", 1000000);
		onumbersTR.put("milyar", 1000000000);

	}

	public long wordToNumber(String input, String lang) {
		if (lang == "ENG") {
			return convertENG(input);
		} else if (lang == "TR") {
			return ConvertTR(input);
		}
		return 0;
	}

	private long convertENG(String input) {
		System.out.println("===========\nInput string = " + input);
		long sum = 0;
		Integer temp = null;
		Integer previous = 0;
		String[] splitted = input.toLowerCase().split(" ");
		for (String split : splitted) {

			if (numbers.get(split) != null) {
				temp = numbers.get(split);
				sum = sum + temp;
				previous = previous + temp;
				
			} else if (onumbers.get(split) != null) {
				if (sum != 0) {
					sum = sum - previous;
				}
				
				sum = sum + (long) previous * (long) onumbers.get(split);
				temp = null;
				previous = 0;

			} else if (tnumbers.get(split) != null) {
				temp = tnumbers.get(split);
				sum = sum + temp;
				previous = temp;
			}
		}
		return sum;
	}

	private long ConvertTR(String input) {
		System.out.println("===========\nInput string = " + input);
		long sum = 0;
		Integer temp = null;
		Integer previous = 0;
		String[] splitted = input.toLowerCase().split(" ");
		// splitted[0]= "iki"
		// splitted[1]= "yüz"
		// splitted[2]= "beş"
		// -----------------
		// splitted[0]= "bin"
		// splitted[1]= "yüz"
		// splitted[2]= "beş"
		for (String split : splitted) {

			if (numbersTR.get(split) != null) {
				temp = numbersTR.get(split);
				sum = sum + temp;
				previous = previous + temp;
			} else if (onumbersTR.get(split) != null) {
				if (sum != 0) {
					sum = sum - previous;
				}
				if (previous == 0) {
					previous = 1;
				}
				sum = sum + (long) previous * (long) onumbersTR.get(split); // 1000
				temp = null;
				previous = 0;

			} else if (tnumbersTR.get(split) != null) {
				temp = tnumbersTR.get(split);
				sum = sum + temp;
				previous = temp;
			}

		}

		return sum;
	}
}
