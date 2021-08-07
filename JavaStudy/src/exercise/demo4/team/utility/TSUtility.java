package exercise.demo4.team.utility;

import java.util.Scanner;

/**
 * TSUtility工具类：
 * 将不同的功能封装为方法，就是可以直接通过调用方法使用它的功能，而无需考虑具体的功能实现细节
 */
public class TSUtility {
    private static Scanner scanner = new Scanner(System.in);

    /**
     * 用于界面菜单的选择。该方法读取键盘，如果用户键入’1’-’4’中的任意字符，则方法返回。返回值为用户键入字符。
     *
     * @return char：返回一个字符
     */
    public static char readMenuSelection() {
        char c;
        for (; ; ) {
            String str = readKeyBoard(1, false);
            c = str.charAt(0);
            if (c != '1' && c != '2' &&
                    c != '3' && c != '4') {
                System.out.print("选择错误，请重新输入：");
            } else break;
        }
        return c;
    }

    /**
     * 按回车键继续...
     */
    public static void readReturn() {
        System.out.print("按回车键继续...");
        readKeyBoard(100, true);
    }

    /**
     * 从键盘读取一个长度不超过2位的整数，并将其作为方法的返回值。
     *
     * @return 返回一个两位整数
     */
    public static int readInt() {
        int n;
        for (; ; ) {
            String str = readKeyBoard(2, false);
            try {
                n = Integer.parseInt(str);
                break;
            } catch (NumberFormatException e) {
                System.out.print("数字输入错误，请重新输入：");
            }
        }
        return n;
    }

    /**
     * 用于确认选择的输入。该方法从键盘读取‘Y’或’N’，并将其作为方法的返回值。
     *
     * @return 返回一个字符。
     */
    public static char readConfirmSelection() {
        char c;
        for (; ; ) {
            String str = readKeyBoard(1, false).toUpperCase();
            c = str.charAt(0);
            if (c == 'Y' || c == 'N') {
                break;
            } else {
                System.out.print("选择错误，请重新输入：");
            }
        }
        return c;
    }

    /**
     * 从键盘中读取不超过指定长度的字符串
     *
     * @param limit       字符串的最大长度
     * @param blankReturn true:回车结束当前输入,即不输入任何信息
     *                    false:回车不会结束当前输入
     * @return String:返回一个字符串
     */
    private static String readKeyBoard(int limit, boolean blankReturn) {
        String line = "";

        while (scanner.hasNextLine()) {
            line = scanner.nextLine();
            if (line.length() == 0) {
                if (blankReturn) return line;
                else continue;
            }

            if (line.length() < 1 || line.length() > limit) {
                System.out.print("输入长度（不大于" + limit + "）错误，请重新输入：");
                continue;
            }
            break;
        }

        return line;
    }
}
