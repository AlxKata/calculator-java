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

        if (sumRoman < 0) {
            try {
                throw new IOException();
            } catch (IOException e) {
                System.out.println("Римское число меньше единицы");
                System.exit(1);
            }
        }


        return sumRoman;
    }
}
