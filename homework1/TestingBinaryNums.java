package homework1;

public class TestingBinaryNums {

	public static void main(String[] args) {
		// Constructor Test
		System.out.println("constructor test");
		BinaryNumber bn1 = new BinaryNumber(7);
		// BinaryNumber bntest1 = new BinaryNumber(0);
		BinaryNumber bn2 = new BinaryNumber("1011001");
		// BinaryNumber bntest2 = new BinaryNumber("10201");

		// test print
		System.out.println("print test");
		System.out.println(bn1);
		System.out.println(bn2);

		// length test
		System.out.println("length test");
		System.out.println(bn1.getLength());
		System.out.println(bn2.getLength());

		// get digit test
		System.out.println("digit test");
		bn2 = new BinaryNumber("011001");
		// System.out.println(bn2.getDigit(-1));
		// System.out.println(bn2.getDigit(7));
		System.out.println(bn2.getDigitLeft(0));
		System.out.println(bn2.getDigit(5));

		// get inner array test
		System.out.println("inner array test");
		bn1 = new BinaryNumber("011001");
		bn2 = new BinaryNumber("011001");
		System.out.println(bn1.getInnerArrayString());
		System.out.println(bn2.getInnerArrayString());

		// test bwor
		System.out.println("bwor test");
		bn1 = new BinaryNumber("1101011");
		bn2 = new BinaryNumber("1001011");
		System.out.println(bn1 + ", " + bn2);
		System.out.println(BinaryNumber.getbworString(bn1, bn2));

		// test bwand
		System.out.println("bwand test");
		bn1 = new BinaryNumber("1010101");
		bn2 = new BinaryNumber("1010110");
		System.out.println(bn1 + ", " + bn2);
		System.out.println(BinaryNumber.getbwandString(bn1, bn2));

		// test bitshift
		System.out.println("bitshift test");
		bn2 = new BinaryNumber("10010101101010111100001");
		System.out.println(bn2);
		System.out.println("original len: " + bn2.getLength());
		int leftamount = 7;
		bn2.bitShift(1, leftamount);
		System.out.println("shifted " + leftamount + " left: " + bn2);
		System.out.println("new len: " + bn2.getLength());
		int rightamount = 5;
		bn2.bitShift(-1, rightamount);
		System.out.println("shifted " + rightamount + " right: " + bn2);
		System.out.println("new len: " + bn2.getLength());
		System.out.println(bn2);
		// bn2.bitShift(0, 3);

		// test add
		System.out.println("add test");
		bn1 = new BinaryNumber("1111110101010010101110100100");
		bn2 = new BinaryNumber("1111110010111001100010101110");
		System.out.println(bn1 + ", " + bn2);
		bn2.add(bn1);
		System.out.println(bn2);
		System.out.println(bn2.toDecimal());
		
		// test decimal
		System.out.println("decimal test");
		bn2 = new BinaryNumber("10010101011000101011101010");
		System.out.println(bn2);
		System.out.println(bn2.toDecimal());
	}
}
