import java.io.IOException;

public class Methods {
    public static void checkQuantity(String[] cell) {
        for (int i = 0; i < cell.length; i++) {
            int checking = Integer.parseInt(cell[i]);
            if (checking < 1 || checking > 10) {
                try {
                    throw new IOException();
                } catch (IOException e) {
                    System.out.println("Вы превысили предел вводимого значения");
                    System.exit(1);
                }
            }
        }
    }
    public static int convertRoman (String convertableArray) {
        char[] arrDigit = convertableArray.toCharArray();
        int[] arrRoman = new int [arrDigit.length];
        int tempRoman = 0;

        for (int i = 0; i < arrDigit.length; i++) {
            if (arrDigit[i] == 'I') {
                arrRoman[i] = 1;
            } else if (arrDigit[i] == 'V') {
                arrRoman[i] = 5;
            } else if (arrDigit[i] == 'X') {
                arrRoman[i] = 10;
            }
        }

        if (arrRoman.length - 1 == 0) {
            tempRoman = arrRoman[0];
        } else {
            tempRoman = arrRoman[arrRoman.length -1];
            for (int i = arrRoman.length - 1; i > 0; i--) {
                if (arrRoman[i] > arrRoman[i - 1]) {
                    tempRoman -= arrRoman[i - 1];
                } else if (arrRoman[i] == arrRoman[i - 1]) {
                    tempRoman += arrRoman[i - 1];
                } else if (arrRoman[i] < arrRoman[i - 1]) {
                    tempRoman += arrRoman[i - 1];
                }
            }
        }

        if (tempRoman < 1 || tempRoman > 10) {
            try {
                throw new IOException();
            } catch (IOException e) {
                System.out.println("Вы превысили предел вводимого значения");
                System.exit(1);
            }
        }
        return tempRoman;
    }
    public static int checkRoman (String romanDigit) {
        String[] splitRoman = null;
        String firstDigit;
        String secondDigit;
        int sumRoman = 0;

        if (romanDigit.contains("+")) {
            splitRoman = romanDigit.split("\\+");
            firstDigit = splitRoman[0];
            secondDigit = splitRoman[1];
            sumRoman = convertRoman(firstDigit) + convertRoman(secondDigit);
        } else if (romanDigit.contains("-")) {
            splitRoman = romanDigit.split("-");
            firstDigit = splitRoman[0];
            secondDigit = splitRoman[1];
            sumRoman = convertRoman(firstDigit) - convertRoman(secondDigit);
        } else if (romanDigit.contains("/")) {
            splitRoman = romanDigit.split("/");
            firstDigit = splitRoman[0];
            secondDigit = splitRoman[1];
            sumRoman = convertRoman(firstDigit) / convertRoman(secondDigit);
        } else if (romanDigit.contains("*")) {
            splitRoman = romanDigit.split("\\*");
            firstDigit = splitRoman[0];
            secondDigit = splitRoman[1];
            sumRoman = convertRoman(firstDigit) * convertRoman(secondDigit);
        } else {
            try {
                throw new IOException();
            } catch (IOException e) {
                System.out.println("Неккоректная операция");
                System.exit(1);
            }
        }

        if (sumRoman < 1) {
            try {
                throw new IOException();
            } catch (IOException e) {
                System.out.println("Римское число меньше единицы");
                System.exit(1);
            }
        }


        return sumRoman;
    }

    public static void operationQuantity (String exmp) {
        int quantity = 0;
        char[] symbolQuantity = exmp.toCharArray();
        for (int i = 0; i < exmp.length(); i++) {
            if (symbolQuantity[i] == '+' || symbolQuantity[i] == '-' || symbolQuantity[i] == '/' || symbolQuantity[i] == '*') {
                quantity += 1;
            }
        }

        if (quantity > 1) {
            try {
                throw new IOException();
            } catch (IOException e) {
                System.out.println("Количество арифметических операций > 1");
                System.exit(1);
            }
        }
    }

    public static void intToRoman (int exmp) {
        while (exmp > 0) {
            if (exmp == 100) {
                System.out.print("C");
                exmp -= 100;
            } else if (exmp < 100 && exmp >= 50) {
                System.out.print("L");
                exmp -= 50;
            } else if (exmp < 50 && exmp >= 10) {
                System.out.print("X");
                exmp -= 10;
            } else if (exmp == 9) {
                System.out.print("IX");
                exmp -= 9;
            } else if (exmp < 9 && exmp >= 5) {
                System.out.print("V");
                exmp -= 5;
            } else if (exmp == 4) {
                System.out.print("IV");
                exmp -= 4;
            } else if (exmp < 4 && exmp > 1) {
                System.out.print("I");
                exmp -= 1;
            } else if (exmp == 1) {
                System.out.print("I");
                exmp -= 1;
            }
        }
    }
}
