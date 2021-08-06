package exercise.demo3.service;

import exercise.demo3.bean.Customer;

/**
 * CustomerList为Customer对象的管理模块,内部用数组管理一组Customer对象
 * 并提供相应的添加,修改,删除和遍历方法,供Customer调用
 */
public class CustomerList {
    private Customer[] customers;/* 用来保存客户对象的数组 */
    private int total = 0;/* 记录已保存客户对象的数量 */

    /**
     * 初始化Customers数组
     *
     * @param totalCustomer 指定Customers数组的最大空间
     */
    public CustomerList(int totalCustomer) {
        customers = new Customer[totalCustomer];
    }

    /**
     * 将指定的客户添加到数组中
     *
     * @param customer 具体的客户
     * @return true:添加成功 false:添加失败
     */
    public boolean addCustomer(Customer customer) {
        /* 对象数组已满 */
        if (total >= customers.length) {
            return false;
        }

        /* 添加客户 */
        customers[total++] = customer;
        return true;
    }

    /**
     * 修改指定索引位置的客户信息
     *
     * @param index    客户所在位置
     * @param customer 具体的客户
     * @return true:修改成功 false:修改失败
     */
    public boolean replaceCustomer(int index, Customer customer) {
        /* 索引位置不合理 */
        if (index < 0 || index >= total) {
            return false;
        }

        /* 修改客户信息 */
        customers[index] = customer;
        return true;
    }

    /**
     * 删除指定索引位置的客户信息
     *
     * @param index 客户所在位置
     * @return true:删除成功 false:删除失败
     */
    public boolean deleteCustomer(int index) {
        /* 索引位置不合理 */
        if (index < 0 || index >= total) {
            return false;
        }

        /* 删除客户信息 */
        for (int i = index; i < total - 1; i++) {
            customers[i] = customers[i + 1];
        }

        /* 将最后一个元素置空 */
        customers[total - 1] = null;
        total--;
        return true;
    }

    /**
     * 获取所有客户信息
     *
     * @return Customer[]:返回一个保存所有客户信息的数组
     */
    public Customer[] getAllCustomers() {
        /* 创建一个新数组,长度为total */
        Customer[] custs = new Customer[total];

        /* 将客户信息复制给该数组 */
        for (int index = 0; index < total; index++) {
            custs[index] = customers[index];
        }

        return custs;
    }

    /**
     * 获取指定索引位置的客户信息
     *
     * @param index 客户所在位置
     * @return Customer:返回客户信息
     */
    public Customer getCustomer(int index) {
        /* 索引位置不合理 */
        if (index < 0 || index >= total) {
            return null;
        }

        return customers[index];
    }

    /**
     * 获取客户数量
     * @return  int:客户数量
     */
    public int getTotal() {
        return total;
    }

}