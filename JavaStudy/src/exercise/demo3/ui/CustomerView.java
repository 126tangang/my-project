package exercise.demo3.ui;

/**
 * 项目二:客户信息管理软件
 */

import exercise.demo2.Utility;
import exercise.demo3.bean.Customer;
import exercise.demo3.service.CustomerList;
import exercise.demo3.utility.CMUtility;

import javax.sound.midi.Soundbank;

/**
 * CustomerView为主模块,负责菜单的显示和处理用户操作
 */
public class CustomerView {
    CustomerList customerList = new CustomerList(10);

    public CustomerView() {
        /* 测试数据 */
        Customer customer = new Customer("孙悟空", '男', 18, "13012341234", "126@qq.com");

        customerList.addCustomer(customer);
    }

    /**
     * 显示客户信息管理软件主界面
     */
    public void enterMainMenu() {
        boolean flag = true;

        while (flag) {

            System.out.println("---------------------------客户信息管理软件---------------------------\n");
            System.out.println("                            1 添加客户");
            System.out.println("                            2 修改客户");
            System.out.println("                            3 删除客户");
            System.out.println("                            4 客户列表");
            System.out.println("                            5 退   出\n");
            System.out.print("                  请选择(1-5):");

            /* 选择(1-5) */
            char selection = CMUtility.readMenuSelection();

            switch (selection) {
                case '1':
                    addNewCustomer();/* 添加客户 */
                    break;
                case '2':
                    modifyCustomer();/* 修改客户 */
                    break;
                case '3':
                    deleteCustomer();/* 删除客户 */
                    break;
                case '4':
                    listAllCustomers();/* 客户列表 */
                    break;
                case '5':
                    /* 退出 */
                    if (isExit()) {
                        flag = false;
                    }
                    break;
            }

        }
    }

    /**
     * 添加客户
     */
    private void addNewCustomer() {
        System.out.println("---------------------------添加客户---------------------------");

        System.out.print("姓名:");
        String name = CMUtility.readString(10);

        System.out.print("性别:");
        char gender = CMUtility.readChar();

        System.out.print("年龄:");
        int age = CMUtility.readInt();

        System.out.print("电话号码:");
        String phone = CMUtility.readString(11);

        System.out.print("电子邮箱:");
        String email = CMUtility.readString(26);

        Customer customer = new Customer(name, gender, age, phone, email);
        boolean isSucceed = customerList.addCustomer(customer);
        if (isSucceed) {
            System.out.println("---------------------------添加客户成功---------------------------");
        } else {
            System.out.println("---------------------------客户目录已满,添加客户失败---------------------------");
        }
    }

    /**
     * 修改客户
     */
    private void modifyCustomer() {
        System.out.println("---------------------------修改客户---------------------------");

        while (true) {
            System.out.print("请选择待修改客户编号(-1退出):");
            int num = CMUtility.readInt();

            if (num == -1) {
                return;
            }

            Customer customer = customerList.getCustomer(num - 1);
            if (customer == null) {
                System.out.println("无法找到指定客户!");
            } else {
                System.out.print("姓名(" + customer.getName() + "):");
                String name = CMUtility.readString(10, customer.getName());

                System.out.print("性别(" + customer.getGender() + "):");
                char gender = CMUtility.readChar(customer.getGender());

                System.out.print("年龄(" + customer.getAge() + "):");
                int age = CMUtility.readInt(10, customer.getAge());

                System.out.print("电话号码(" + customer.getPhone() + "):");
                String phone = CMUtility.readString(11, customer.getPhone());

                System.out.print("电子邮件(" + customer.getEmail() + "):");
                String email = CMUtility.readString(26, customer.getEmail());

                Customer newCustomer = new Customer(name, gender, age, phone, email);
                customerList.replaceCustomer(num - 1, newCustomer);

                break;
            }
        }

        System.out.println("---------------------------修改完成---------------------------");
    }

    /**
     * 删除客户
     */
    private void deleteCustomer() {
        System.out.println("---------------------------删除客户---------------------------");

        while (true) {
            System.out.print("请选择待删除客户编号(-1退出):");
            int num = CMUtility.readInt();

            if (num == -1) {
                return;
            }

            Customer customer = customerList.getCustomer(num - 1);
            if (customer == null) {
                System.out.println("无法找到指定客户!");
            } else {
                System.out.print("确认是否删除(Y/N):");
                char isDelete = CMUtility.readConfirmSelection();
                if (isDelete == 'Y') {
                    customerList.deleteCustomer(num - 1);
                } else {
                    return;
                }

                break;
            }
        }
        System.out.println("---------------------------删除成功---------------------------");
    }

    /**
     * 显示所有客户
     */
    private void listAllCustomers() {
        System.out.println("---------------------------客户列表---------------------------");

        if (customerList.getTotal() == 0) {
            System.out.println("没有客户记录！");
        } else {
            System.out.println("编号    \t姓名      \t性别    \t年龄    \t电话          \t邮箱");
            Customer[] customers = customerList.getAllCustomers();
            for (int index = 0; index < customers.length; index++) {
                System.out.println((index + 1) + "    \t" + customers[index].getName() + "    \t" + customers[index].getGender() + "    \t" + customers[index].getAge() + "    \t" + customers[index].getPhone() + "    \t" + customers[index].getEmail());
            }
        }


        System.out.println("---------------------------客户列表完成---------------------------\n");
    }

    /**
     * 确认是否退出程序
     *
     * @return true:退出程序 false:不退出程序
     */
    private boolean isExit() {
        System.out.print("确认是否退出(Y/N):");
        char isExit = Utility.readConfirmSelection();
        if (isExit == 'Y') {
            return true;
        }
        return false;
    }
}
