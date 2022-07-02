package odevJavacamp;

public class OSGIservice {
	String unitsMap[] = { "zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten",
			"eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen" };
	String tensMap[] = { "zero", "ten", "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety" };

	String unitsMapTR[] = { "sıfır", "bir", "iki", "üç", "dört", "beş", "altı", "yedi", "sekiz", "dokuz", "on" };
	String tensMapTR[] = { "sıfır", "on", "yirmi", "otuz", "kırk", "elli", "altmış", "yetmiş", "seksen", "doksan" };

	public String NumberToWords(int number, String lang) {

		String billion = " billion ";
		String million = " million ";
		String thousand = " thousand ";
		String hundred = " hundred ";
		if (lang == "TR") {
			billion = " milyar ";
			million = " milyon ";
			thousand = " bin ";
			hundred = " yüz ";
		}
		// number=1105
		if (number == 0)
			return "zero";

		String words = "";

		if ((number / 1000000000) > 0) {
			String wrd = NumberToWords((number / 1000000000), lang);
			if (!wrd.equals("bir")) {
				words += wrd + billion;
			} else {
				words += billion;
			}
			number %= 1000000000;
		}

		if ((number / 1000000) > 0) {
			String wrd = NumberToWords((number / 1000000), lang);
			if (!wrd.equals("bir")) {
				words += wrd + million;
			} else {
				words += million;
			}
			number %= 1000000;
		}

		if ((number / 1000) > 0) {
			String wrd = NumberToWords(number / 1000, lang); // word=bir
			if (!wrd.equals("bir")) {
				words += wrd + thousand; // word=bir
			} else {
				words += thousand;
			}
			number %= 1000; // 105
		}

		if ((number / 100) > 0) {
			String wrd = NumberToWords(number / 100, lang); // recursive //
			if (!wrd.equals("bir")) {
				words += wrd + hundred;
			} else {
				words += hundred;
			}
			number %= 100;
		}

		if (number > 0) {
			if (lang == "ENG") {
				if (number < 20)
					words += unitsMap[number];
				else {
					words += tensMap[number / 10];
					if ((number % 10) > 0)
						words += "-" + unitsMap[number % 10];
				}
			} else if (lang == "TR") {
				if (number < 10)
					words += unitsMapTR[number];
				else {
					words += tensMapTR[number / 10];
					if ((number % 10) > 0)
						words += "-" + unitsMapTR[number % 10];
				}

			}

		}

		return words;
	}

}
