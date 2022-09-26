package chiffres_romains;

public class ChiffresRomains {

	public static void main(String[] args) {
		Converter converter = new Converter();
		
		String str = "LXV";
		try {
		int number = converter.calculNumber(str);

			System.out.println(
			" The Integer form for Roman Numerals " + str + " is " + number);
		} catch(NotAuthorizedCharException e) {
			System.out.println(e);
		}
	

	}
	

}
