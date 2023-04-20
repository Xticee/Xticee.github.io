import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        while (true) {
            System.out.println(calc(new Scanner(System.in).nextLine()));
        }
    }
    public static String calc(String input) {
        String[] array = input.split(" ");
        if(array.length != 3) throw new IllegalArgumentException();
        String result;
        boolean flag = false;
        if(array[0].contains("I") || array[0].contains("V") || array[0].contains("X") && array[2].contains("I") || array[2].contains("V") || array[2].contains("X")) {
            flag = true;
            array[0] = switch(array[0]) {
                case "I" -> "1";
                case "II" -> "2";
                case "III" -> "3";
                case "IV" -> "4";
                case "V" -> "5";
                case "VI" -> "6";
                case "VII" -> "7";
                case "VIII" -> "8";
                case "IX" -> "9";
                case "X" -> "10";
                default -> throw new IllegalArgumentException();
            };
            array[2] = switch(array[2]) {
                case "I" -> "1";
                case "II" -> "2";
                case "III" -> "3";
                case "IV" -> "4";
                case "V" -> "5";
                case "VI" -> "6";
                case "VII" -> "7";
                case "VIII" -> "8";
                case "IX" -> "9";
                case "X" -> "10";
                default -> throw new IllegalArgumentException();
            };
        }
        result  = switch(array[1]) {
            case "+" -> String.valueOf(Integer.parseInt(array[0]) + Integer.parseInt(array[2]));
            case "-" -> String.valueOf(Integer.parseInt(array[0]) - Integer.parseInt(array[2]));
            case "*" -> String.valueOf(Integer.parseInt(array[0])  * Integer.parseInt(array[2]));
            case "/" -> String.valueOf(Integer.parseInt(array[0]) / Integer.parseInt(array[2]));
            default -> throw new IllegalArgumentException();
        };
        if (flag) {
            String[] arab1 = {"X","XX","XXX","XL","L","LX","LXX","LXXX","XC"};
            String[] arab2 = {"I","II","III","IV","V","VI","VII","VIII","IX"};
            if(result.equals("100")) return "C";
            if(Integer.parseInt(result) % 10 == 0) {
                result = 0 + "" + (Integer.parseInt(result) / 10);
            }
            String[] temp = result.split("");
            if (temp.length == 1) {
                result = arab2[Integer.parseInt(temp[0]) - 1];
            }
            if (temp.length == 2) {
                if (temp[0].equals("0")) {
                    result = arab1[Integer.parseInt(temp[1]) - 1];
                } else {
                    result = arab1[Integer.parseInt(temp[0]) - 1] + arab2[Integer.parseInt(temp[1]) - 1];
                }
            }
        }
        return result;
    }
}
