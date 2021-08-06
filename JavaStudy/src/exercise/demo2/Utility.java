package exercise.demo2;

import java.util.Scanner;

/**
 * Utility工具类：
 * 将不同的功能封装为方法，就是可以直接通过调用方法使用它的功能，而无需考虑具体的功能实现细节。
 */
public class Utility {
    private static Scanner scanner = new Scanner(System.in);

    /**
     * 从键盘中读取不超过指定长度的字符串，且长度不小于1。
     *
     * @param limit 字符串的最大长度
     * @return String  返回一个字符串
     */
    private static String readKeyboard(int limit) {
        String string = "";

        while (scanner.hasNext()) {
            string = scanner.nextLine();

            if (string.length() >= 1 && string.length() <= limit) {
                break;
            }

            System.out.print("输入长度(不大于" + limit + ")错误，请重新输入:");
        }

        return string;
    }

    /**
     * 用于界面菜单的选择。该方法读取键盘，如果用户键入’1’-’4’中的任意字符，则方法返回。返回值为用户键入字符。
     *
     * @return 返回一个字符。
     */
    public static char readMenuSelection() {
        char c;

        while (true) {
            c = readKeyboard(1).charAt(0);

            if (c != '1' && c != '2' && c != '3' && c != '4') {
                System.out.print("选择错误,请重新输入:");
            } else {
                break;
            }
        }

        return c;
    }

    /**
     * 用于确认选择的输入。该方法从键盘读取‘Y’或’N’，并将其作为方法的返回值。
     *
     * @return 返回一个字符。
     */
    public static char readConfirmSelection() {
        char c;

        while (true) {
            //忽略大小写
            c = readKeyboard(1).toUpperCase().charAt(0);

            if (c != 'Y' && c != 'N') {
                System.out.print("选择错误,请重新输输入:");
            } else {
                break;
            }
        }

        return c;
    }

    /**
     * 用于收入和支出金额的输入。该方法从键盘读取一个不超过5位长度的整数，并将其作为方法的返回值。
     *
     * @return 返回一个整数。
     */
    public static int readNumber() {
        int num;

        while (true) {
            String string = readKeyboard(5);

            try {
                num = Integer.parseInt(string);
                break;
            } catch (NumberFormatException e) {
                System.out.print("数字输入错误,请重新输入:");
            }
        }

        return num;
    }

    /**
     * 用于收入和支出说明的输入。该方法从键盘读取一个不超过8位长度的字符串，并将其作为方法的返回值。
     *
     * @return 返回一个字符串。
     */
    public static String readString() {
        String string = readKeyboard(8);
        return string;
    }
}