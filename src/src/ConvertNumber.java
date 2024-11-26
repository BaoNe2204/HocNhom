package src;
public class ConvertNumber {
    
    public ConvertNumber(){
        
        
        
    }
    
    public static String Convert(String number, int fromBase, int toBase) {
        if (fromBase == 10) {
            return ConvertFormDecimal(number, toBase);
        } else {
            return ConvertFormDecimal(ConvertToDecimal(number, fromBase), toBase);
        }
    }

    public static String ConvertToDecimal(String number, int fromBase) {
        String result;
        if (number.contains(".") || number.contains(",")) {
            String[] numberSplit = number.split("[.,]");
            String numberSplit0 = ConvertIntegerToDec(numberSplit[0], fromBase);
            String numberSplit1 = ConvertDoubleToDec(numberSplit[1], fromBase);
            result = numberSplit0 + "." + numberSplit1;
            return result;
        } else {
            result = ConvertIntegerToDec(number, fromBase);
            return result;
        }

    }

    public static String ConvertDoubleToDec(String number, int fromBase) {
        char[] characterNumber = number.toCharArray();
        double sum = 0;
        int count = 1;
        for (int i = 0; i < characterNumber.length; i++) {
            sum += NumberChar(characterNumber[i]) * Math.pow(fromBase, -count);
            count++;
        }
        String result = String.valueOf(sum).substring(2);
        return result;
    }

    public static String ConvertIntegerToDec(String number, int fromBase) {
        int DecNum = Integer.parseInt(number, fromBase);
        String result = Integer.toString(DecNum, 10);
        return result;
    }

    public static String ConvertFormDecimal(String number, int toBase) {
        double numberInteger = Double.parseDouble(number);
        if (numberInteger % 1 == 0) {
            String result = ConvertInteger(String.valueOf((int) numberInteger), toBase);
            return result;
        } else {
            String result = "";
            String[] numberSplit = number.split("[.,]");
            String splitDouble = "0." + numberSplit[1];
            double convertDouble = Double.parseDouble(splitDouble);
            String resultInt = "";
            String resultDouble = "";
            resultInt = ConvertInteger(String.valueOf(numberSplit[0]), toBase);
            resultDouble = ConvertDouble(String.valueOf(convertDouble), toBase);
            result = resultInt + resultDouble;
            return result;
        }
    }

    public static String ConvertInteger(String number, int toBase) {
        StringBuilder result = new StringBuilder();

        String character;
        int characterInt;
        int numberInt = Integer.parseInt(number);
        while (numberInt > 0) {
            characterInt = numberInt % toBase;
            numberInt /= toBase;
            if (characterInt < 10) {
                character = String.valueOf(characterInt);
            } else {
                character = CharNumber(characterInt);
            }
            result.append(character);
        }
        return result.reverse().toString();
    }

    public static String ConvertDouble(String doubleNumber, int toBase) {
        StringBuilder result = new StringBuilder();
        result.insert(0, ".");
        int count = 4;
        int numberInt;
        double numberDouble = Double.parseDouble(doubleNumber);
        for (int i = 1; i <= count; i++) {
            numberInt = (int) (numberDouble * toBase);
            if (numberInt < 10) {
                result.append(String.valueOf(numberInt));
            } else {
                result.append(CharNumber(numberInt));
            }
            double calculator = numberDouble * toBase;
            String[] splitNumber = String.valueOf(calculator).split("[.,]");
            numberDouble = Double.parseDouble("0." + splitNumber[1]);
        }
        return result.toString();
    }

    public static String CharNumber(int n) {
        switch (n) {
            case 10:
                return "A";
            case 11:
                return "B";
            case 12:
                return "C";
            case 13:
                return "D";
            case 14:
                return "E";
            case 15:
                return "F";
            case 16:
                return "G";
            case 17:
                return "H";
            case 18:
                return "I";
            case 19:
                return "J";
            case 20:
                return "K";
            case 21:
                return "L";
            case 22:
                return "M";
            case 23:
                return "N";
            case 24:
                return "O";
            case 25:
                return "P";
            case 26:
                return "Q";
            case 27:
                return "R";
            case 28:

                return "S";
            case 29:
                return "T";
            case 30:

                return "U";
            case 31:
                return "V";
            case 32:

                return "W";
            case 33:
                return "X";
            case 34:

                return "Y";
            case 35:
                return "Z";

        }
        return null;
    }

    public static int NumberChar(char n) {
        n = Character.toUpperCase(n);

        switch (n) {
            case '0':
                return 0;
            case '1':
                return 1;
            case '2':
                return 2;
            case '3':
                return 3;
            case '4':
                return 4;
            case '5':
                return 5;
            case '6':
                return 6;
            case '7':
                return 7;
            case '8':
                return 8;
            case '9':
                return 9;
            case 'A':
                return 10;
            case 'B':
                return 11;
            case 'C':
                return 12;
            case 'D':
                return 13;
            case 'E':
                return 14;
            case 'F':
                return 15;
            case 'G':
                return 16;
            case 'H':
                return 17;
            case 'I':
                return 18;
            case 'J':
                return 19;
            case 'K':
                return 20;
            case 'L':
                return 21;
            case 'M':
                return 22;
            case 'N':
                return 23;
            case 'O':
                return 24;
            case 'P':
                return 25;
            case 'Q':
                return 26;
            case 'R':
                return 27;
            case 'S':
                return 28;
            case 'T':
                return 29;
            case 'U':
                return 30;
            case 'V':
                return 31;
            case 'W':
                return 32;
            case 'X':
                return 33;
            case 'Y':
                return 34;
            case 'Z':
                return 35;
            default:
                throw new IllegalArgumentException("Invalid character: " + n);
        }
    }
    public String CalculatorConverNumber(String firstNumber, int firstBase, String secondNumber,int secondBase,int finalBase,int calculator){
        String firstNumberDec = ConvertToDecimal(firstNumber,firstBase);
        String secondNumberDec = ConvertToDecimal(secondNumber,secondBase);
        double firstNumberDouble = Double.parseDouble(firstNumber);
        double secondNumberDouble = Double.parseDouble(secondNumber);
        String result;
        switch(calculator){
            case 0: //+
                double sum = firstNumberDouble + secondNumberDouble;
                result = ConvertFormDecimal(String.valueOf(sum),finalBase);
                return result;
            case 1: //-
                double sign = firstNumberDouble - secondNumberDouble;
                result = ConvertFormDecimal(String.valueOf(sign),finalBase);
                return result;
            case 2: //x
                double time = firstNumberDouble * secondNumberDouble;
                result = ConvertFormDecimal(String.valueOf(time),finalBase);
                return result;
            case 3: // /
                double divide = firstNumberDouble / secondNumberDouble;
                result = ConvertFormDecimal(String.valueOf(divide),finalBase);
                return result;
     
        }
        
        return null;
                }
}
