package exercise.demo3.utility;

import java.util.Scanner;

/**
 * CMUtility工具类：
 * 将不同的功能封装为方法，就是可以直接通过调用方法使用它的功能，而无需考虑具体的功能实现细节
 */
public class CMUtility {
    private static Scanner scanner = new Scanner(System.in);


    /**
     * 从键盘中读取不超过指定长度的字符串
     *
     * @param limit       字符串的最大长度
     * @param blankReturn true:回车结束当前输入,即不输入任何信息
     *                    false:回车不会结束当前输入
     * @return String:返回一个字符串
     */
    private static String readKeyboard(int limit, boolean blankReturn) {
        String string = "";

        while (true) {
            string = scanner.nextLine();

            if (string.length() == 0) {
                /* 根据blankReturn判断回车是否结束当前输入 */
                if (blankReturn) {
                    return string;
                }
            } else if (string.length() >= 1 || string.length() <= limit) {
                break;
            } else {
                System.out.print("输入长度(不大于" + limit + ")错误，请重新输入:");
            }

        }

        return string;
    }

    /**
     * 用于界面菜单的选择。该方法读取键盘，如果用户键入’1’-’5’中的任意字符，则方法返回。返回值为用户键入字符。
     *
     * @return char：返回一个字符
     */
    public static char readMenuSelection() {
        char c;

        while (true) {
            c = readKeyboard(1, false).charAt(0);

            if (c != '1' && c != '2' && c != '3' && c != '4' && c != '5') {
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
            c = readKeyboard(1, false).toUpperCase().charAt(0);

            if (c != 'Y' && c != 'N') {
                System.out.print("选择错误,请重新输输入:");
            } else {
                break;
            }
        }

        return c;
    }

    /**
     * 从键盘读取一个长度不超过limit的字符串，并将其作为方法的返回值。
     *
     * @param limit 限制字符串的长度
     * @return 返回一个字符串
     */
    public static String readString(int limit) {
        return readKeyboard(limit, false);
    }

    /**
     * 从键盘读取一个字符，并将其作为方法的返回值。
     *
     * @return 返回一个字符
     */
    public static char readChar() {
        return readKeyboard(1, false).charAt(0);
    }

    /**
     * 从键盘读取一个长度不超过2位的整数，并将其作为方法的返回值。
     *
     * @return 返回一个两位整数
     */
    public static int readInt() {
        int num;

        while (true) {
            String string = readKeyboard(2, false);

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
     * 从键盘读取一个长度不超过limit的字符串，并将其作为方法的返回值。
     * 如果用户不输入字符而直接回车，方法将以defaultValue 作为返回值。
     * @param limit 字符串最大长度
     * @param defaultValue  默认值
     * @return
     */
    public static String readString(int limit, String defaultValue) {
        String string = readKeyboard(limit, true);
        return string.equals("") ? defaultValue : string;
    }

    /**
     * 从键盘读取一个字符，并将其作为方法的返回值。
     * 如果用户不输入字符而直接回车，方法将以defaultValue 作为返回值。
     * @param defaultValue  默认值
     * @return  返回一个字符
     */
    public static char readChar(char defaultValue) {
        String string = readKeyboard(1, true);
        return string.equals("") ? defaultValue : string.charAt(0);
    }

    /**
     * 从键盘读取一个长度不超过2位的整数，并将其作为方法的返回值。
     * 如果用户不输入字符而直接回车，方法将以defaultValue 作为返回值。
     * @param limit 数字的最大长度
     * @param defaultValue  默认值
     * @return  一个两位整数
     */
    public static int readInt(int limit, int defaultValue) {
        int num;

        while (true) {
            String string = readKeyboard(limit, true);

            if (string.equals("")) {
                return defaultValue;
            }

            try {
                num = Integer.parseInt(string);
                break;
            } catch (NumberFormatException e) {
                System.out.print("数字输入错误,请重新输入:");
            }
        }
        return num;
    }
}
