package chiffres_romains;

public class Converter {

	/**
	 * 
	 * @param romanNumeral
	 * @return a number that matches roman numerals
	 * @throws NotAuthorizedCharException
	 */
	int calculNumber(String romanNumeral) throws NotAuthorizedCharException {
		int number = 0;
		try {
			if (!romanNumeral.isEmpty() && !isRomanNumeralInvalid(romanNumeral)) {
			
	
			for(int i=0; i < romanNumeral.length(); i++) {
				int nb1 = convertToNumber(romanNumeral.charAt(i), i);
				
				if (i+1 < romanNumeral.length()) {
					int nb2 = convertToNumber(romanNumeral.charAt(i+1), i+1);
					
					if (nb1 >= nb2) {
						number += nb1;
					} else {
						number = number + nb2 - nb1;
						i++;
					}
					
				} else {
					number += nb1;
				}
			}
			} else {
				throw new NotAuthorizedCharException("String is empty.");
			}
		} catch (NullPointerException e) {
			throw new NotAuthorizedCharException("String is null.");
		} catch(Exception e) {
			e.printStackTrace();
		}
		return number;
	}
	
	/**
	 * 
	 * @param romanNumber
	 * @param index
	 * @return return a converted number
	 * @throws NotAuthorizedCharException
	 */
	private int convertToNumber(char romanNumber, int index) throws NotAuthorizedCharException {
		int number = 0;
		switch(romanNumber) {
		case 'I':
			number = 1;
			break;
			
		case 'V':
			number = 5;
			break;
		case 'X':
			number = 10;
			break;
			
		case 'L':
			number = 50;
			break;
			
		case 'C':
			number = 100;
			break;
			
		case 'D':
			number = 500;
			break;
			
		case 'M':
			number = 1000;
			break;
		
		default: 
			throw new NotAuthorizedCharException("At least one non-compliant character at position " + (index+1));
			
		}
		return number;
	}
	
	
	private long occurenceNumber(String s, char c) {
		return s.chars().filter(ch -> ch == c).count();
	}
	
	private int findCharV(String s) {
		return s.indexOf('V');
	}
	
	private boolean isRightCharX(String s, int index) {
		if (index+1 < s.length()) {
			return s.charAt(findCharV(s) + 1) == 'X';
		} else {
			return false;
		}
	}
	
	
	private boolean isRomanNumeralInvalid(String s) throws NotAuthorizedCharException {
		if (occurenceNumber(s, 'V') > 1 || occurenceNumber(s, 'L') > 1 ||  occurenceNumber(s, 'D') > 1) {
			throw new NotAuthorizedCharException("Character V, L or D is repeted more than once.");
		}
		if (occurenceNumber(s, 'I') > 3 || occurenceNumber(s, 'X') > 3 ||  occurenceNumber(s, 'C') > 3) {
			throw new NotAuthorizedCharException("Character I, X or C is repeted more than three times.");
		} if ((findCharV(s) != -1) && isRightCharX(s, findCharV(s))) {
			throw new NotAuthorizedCharException("Character V is before X.");
		}
		return false;
	}
}
