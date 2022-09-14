import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int summ = 0;
        String[] splitter;
        String digitResult = "0";
        boolean flagRoman = false;
        boolean flagArab = false;

        Scanner scanner = new Scanner(System.in);
        String sc = scanner.nextLine();
        String cleanInput = sc.replaceAll(" ", "");
        Methods.operationQuantity(cleanInput);

        if (cleanInput.contains("I") || cleanInput.contains("V") || cleanInput.contains("X")) {
            flagRoman = true;
        }

        if (cleanInput.contains("1") || cleanInput.contains("2") || cleanInput.contains("3")
                || cleanInput.contains("4") || cleanInput.contains("5") || cleanInput.contains("6")
                || cleanInput.contains("7") || cleanInput.contains("8") || cleanInput.contains("9")) {
            flagArab = true;
        }

        if (flagArab == flagRoman) {
            try {
                throw new IOException();
            } catch (IOException e) {
                System.out.println("Некорректный ввод");
            }
        } else if (flagArab == true) {
            digitResult = cleanInput;
            if (digitResult.contains("+")) {
                splitter = digitResult.split("\\+");
                Methods.checkQuantity(splitter);
                summ = Integer.parseInt(splitter[0]) + Integer.parseInt(splitter[1]);
            } else if (digitResult.contains("-")) {
                splitter = digitResult.split("-");
                Methods.checkQuantity(splitter);
                summ = Integer.parseInt(splitter[0]) - Integer.parseInt(splitter[1]);
            } else if (digitResult.contains("/")) {
                splitter = digitResult.split("/");
                Methods.checkQuantity(splitter);
                summ = Integer.parseInt(splitter[0]) / Integer.parseInt(splitter[1]);
            } else if (digitResult.contains("*")) {
                splitter = digitResult.split("\\*");
                Methods.checkQuantity(splitter);
                summ = Integer.parseInt(splitter[0]) * Integer.parseInt(splitter[1]);
            } else {
                try {
                    throw new IOException();
                } catch (IOException e) {
                    System.out.println("Неккоректная операция");
                    System.exit(1);
                }
            }

            System.out.println(summ);
        } else if (flagRoman == true) {
            summ = Methods.checkRoman(cleanInput);
            Methods.intToRoman(summ);
        }
    }
}
