package homework1;

import java.lang.Math;
import java.util.Arrays;

public class BinaryNumber {

	// Data Fields
	private int data[];
	private int length;

	/**
	 * Binary Number Constructor given number of digits length must be greater than
	 * 0
	 * 
	 * @param length int
	 */
	public BinaryNumber(int length) {
		if (length <= 0) {
			throw new IllegalArgumentException("Length binary number must be greater than 0!");
		}
		data = new int[length];
		for (int i = 0; i < length; i++) {
			data[i] = 0;
		}
		this.length = length;
	}

	/**
	 * Binary Number Constructor given string Each digit must be a 1 or 0
	 * 
	 * @param str
	 */
	public BinaryNumber(String str) {
		this.length = str.length();
		data = new int[this.length];
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) != '0' && str.charAt(i) != '1') {
				throw new IllegalArgumentException("All digits must be a 1 or 0!");
			} else {
				data[i] = Character.getNumericValue(str.charAt(i));
			}
		}
	}
	
	/**
	 * Make a copy of a given binary num
	 * @param BinaryNumber
	 */
	BinaryNumber(BinaryNumber current) {
		this.data = current.data;
		this.length = current.length;
	}

	/**
	 * add new 0's to the front of data
	 * 
	 * @param amount int (must be greater than or equal to 0
	 */
	public void prepend(int amount) {
		if (amount < 0) {
			throw new IllegalArgumentException("Amount prepend must be greater than or equal to 0!");
		}
		int[] newdata = new int[amount + this.length];
		for (int i = 0; i < amount; i++) {
			newdata[i] = 0;
		}
		for (int i = 0; i < this.length; i++) {
			newdata[i + amount] = data[i];
		}
		this.data = newdata;
		this.length = newdata.length;
	}

	/**
	 * Getter for length
	 */
	public int getLength() {
		return this.length;
	}

	/**
	 * Getters and setters for binarynum
	 */
	public String toString() {
		String str = "";
		for (int i = 0; i < data.length; i++) {
			str += Integer.toString(data[i]);
		}
		return str;
	}

	public void setStr(String str) {
		this.length = str.length();
		int[] newdata = new int[this.length];
		for (int i = 0; i < str.length(); i++) {
			newdata[i] = Character.getNumericValue(str.charAt(i));
		}
		this.data = newdata;
	}

	/**
	 * Getters and setters for intarray
	 */
	public int[] getInnerArray() {
		return this.data;
	}
	
	/**
	 * get inner array string
	 * @return string
	 */
	public String getInnerArrayString() {
		return Arrays.toString(this.getInnerArray());
	}

	/**
	 * setter for int array
	 * @param intarr int[]
	 */
	public void setIntarr(int[] intarr) {
		this.data = intarr;
		this.length = intarr.length;
	}

	/**
	 * Getters and setters for a given digit
	 * gets digit from left index
	 * @param index int
	 * @return int index value
	 */
	public int getDigit(int index) {
		try {
			return this.data[index];
		} catch (ArrayIndexOutOfBoundsException exception) {
			throw new IllegalArgumentException("Index out of Bounds!");
		}
	}
	
	/**
	 * gets digit from right index
	 * @param index int
	 * @return int index value
	 */
	public int getDigitLeft(int index) {
		try {
			return this.data[this.length - index - 1];
		} catch (ArrayIndexOutOfBoundsException exception) {
			throw new IllegalArgumentException("Index out of Bounds!");
		}
	}

	/**
	 * inserts digit in specific index
	 * @param index int
	 * @param digit int (1 or 0)
	 */
	public void insertDigit(int index, int digit) {
		if (digit != 1 && digit != 0) {
			throw new IllegalArgumentException("New digit must be a 1 or 0!");
		}
		int newlen = this.getLength() + 1;
		int[] newarray = new int[newlen];
		try {
			newarray[index] = digit;
		} catch (ArrayIndexOutOfBoundsException exception) {
			throw new IllegalArgumentException("Index out of Bounds!");
		}
		for (int i = 0; i < index; i++) {
			newarray[i] = data[i];
		}
		for (int i = index; i < newlen; i++) {
			newarray[i] = data[i - 1];
		}
		this.data = newarray;
		this.length = newlen;
	}
	
	public void setDigit(int index, int digit) {
		this.data[index] = digit;
	}

	/**
	 * get Binary Notation
	 */
	public int toDecimal() {
		int decimalValue = 0;
		int lenBinary = this.getLength();
		for (int i = 0; i < lenBinary; i++) {
			decimalValue += this.getDigit(i) * Math.pow(2, lenBinary - i - 1);
		}
		return decimalValue;
	}

	/**
	 * Acts as a setter for length - shifts the bits left and right
	 * 
	 * @param direction int (-1 for left, 1 for right, other invalid)
	 * @param amount    int (any number greater than 0)
	 */
	public void bitShift(int direction, int amount) {
		int lenBinary = this.getLength();
		if (amount < 0) {
			throw new IllegalArgumentException("Amount shift must be greater than or equal to 0!");
		}
		if (direction == 1) {
			if (lenBinary - amount < 0) {
				throw new IllegalArgumentException("Amount shift left is greater than number of digits!");
			}
			int[] newarr = Arrays.copyOfRange(data, 0, lenBinary - amount);
			//if array's length is 0, add one element to make array equal 0.
			if (newarr.length == 0) {
				newarr = new int[1];
				newarr[0] = 0;
			}
			this.data = newarr;
			this.length = newarr.length;
		} else if (direction == -1) {
			int[] newarr = new int[data.length + amount];
			for (int i = 0; i < data.length; i++) {
				newarr[i] = data[i];
			}
			for (int i = data.length; i < data.length + amount; i++) {
				newarr[i] = 0;
			}
			this.data = newarr;
			this.length = newarr.length;
		} else {
			throw new IllegalArgumentException("Shift direction must be +1 or -1!");
		}
	}

	/**
	 * returns the "or" operation of 2 binary numbers
	 * 
	 * @param bn1 BinaryNumber
	 * @param bn2 BinaryNumber
	 * @return
	 */
	public static int[] bwor(BinaryNumber bn1, BinaryNumber bn2) {
		//or is 0 + 0 = 0, 0 + 1 = 1, 1 + 0 = 1, 1 + 1 = 1
		int numdigits = bn1.getLength();
		if (numdigits != bn2.getLength()) {
			throw new IllegalArgumentException("Binary Numbers must be of the same length!");
		}
		int[] result = new int[numdigits];
		for (int i = 0; i < numdigits; i++) {
			if (bn1.getDigit(i) + bn2.getDigit(i) > 0) {
				result[i] = 1;
			} else {
				result[i] = 0;
			}
		}
		return result;
	}
	
	/**
	 * get bwor string
	 * @return string
	 */
	public static String getbworString(BinaryNumber bn1, BinaryNumber bn2) {
		return Arrays.toString(BinaryNumber.bwor(bn1, bn2));
	}

	/**
	 * returns the "and" operation of 2 binary numbers
	 * 
	 * @param bn1 BinaryNumber
	 * @param bn2 BinaryNumber
	 * @return
	 */
	public static int[] bwand(BinaryNumber bn1, BinaryNumber bn2) {
		//or is 0 + 0 = 0, 0 + 1 = 0, 1 + 0 = 0, 1 + 1 = 1
		int numdigits = bn1.getLength();
		if (numdigits != bn2.getLength()) {
			throw new IllegalArgumentException("Binary Numbers must be of the same length!");
		}
		int[] result = new int[numdigits];
		for (int i = 0; i < numdigits; i++) {
			if (bn1.getDigit(i) + bn2.getDigit(i) == 2) {
				result[i] = 1;
			} else {
				result[i] = 0;
			}
		}
		return result;
	}
	
	/**
	 * get bwand string
	 * @return string
	 */
	public static String getbwandString(BinaryNumber bn1, BinaryNumber bn2) {
		return Arrays.toString(BinaryNumber.bwand(bn1, bn2));
	}

	/**
	 * Adds 2 binary numbers together - the current num and an argument num. The
	 * result is stored in this num
	 * 
	 * @param aBinaryNumber
	 */
	public void add(BinaryNumber aBinaryNumber) {
		BinaryNumber binarynumcopy = new BinaryNumber(aBinaryNumber);
		int len = this.getLength();
		int diffinlen = len - binarynumcopy.getLength();
		if (diffinlen > 0) {
			// this num is bigger than other
			binarynumcopy.prepend(diffinlen);
		} else if (diffinlen < 0) {
			// other num is bigger than this
			diffinlen *= -1;
			this.prepend(diffinlen);
			len += diffinlen;
		}
		int carry = 0;
		for (int i = len - 1; i >= 0; i--) {
			int sum = carry + this.getDigit(i) + binarynumcopy.getDigit(i);
			if (sum % 2 == 0) {
				this.setDigit(i, 0);
			} else {
				this.setDigit(i, 1);
			}
			if (sum > 1) {
				carry = 1;
			} else {
				carry = 0;
			}
		}
		if (carry == 1) {
			this.prepend(1);
			this.setDigit(0, 1);
		}
	}
}
