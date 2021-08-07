package exercise.demo4.team.service;

import exercise.demo4.team.domain.*;

import static exercise.demo4.team.service.Data.*;

/**
 * 负责将Data中的数据封装到Employee[]数组中,同时提供相关操作Employee[]的方法
 */
public class NameListService {

    private Employee[] employees;


    /**
     * 根据项目提供的Data类构建相应大小的employees数组,再根据Data类中数据构建不同的对象
     * 包括Employee,Programmer,Designer和Architect对象,以及相关联的Equipment子类的对象
     * 将对象存于数组中
     */
    public NameListService() {

        employees = new Employee[EMPLOYEES.length];

        for (int index = 0; index < employees.length; index++) {
            /* 获取员工类型 */
            int type = Integer.parseInt(EMPLOYEES[index][0]);

            /* 获取Employee的四个基本信息 */
            int id = Integer.parseInt(EMPLOYEES[index][1]);
            String name = EMPLOYEES[index][2];
            int age = Integer.parseInt(EMPLOYEES[index][3]);
            double salary = Double.parseDouble((EMPLOYEES[index][4]));

            Equipment equipment;
            double bonus;
            int stock;

            switch (type) {
                case EMPLOYEE:
                    employees[index] = new Employee(id, name, age, salary);
                    break;
                case PROGRAMMER:
                    equipment = creatEquipment(index);
                    employees[index] = new Programmer(id, name, age, salary, equipment);
                    break;
                case DESIGNER:
                    equipment = creatEquipment(index);
                    bonus = Double.parseDouble(EMPLOYEES[index][5]);
                    employees[index] = new Designer(id, name, age, salary, equipment, bonus);
                    break;
                case ARCHITECT:
                    equipment = creatEquipment(index);
                    bonus = Double.parseDouble(EMPLOYEES[index][5]);
                    stock = Integer.parseInt(EMPLOYEES[index][6]);
                    employees[index] = new Architect(id, name, age, salary, equipment, bonus, stock);
                    break;
            }
        }

    }

    /**
     * 获取index下的员工的设备
     * @param index
     * @return  返回具体的设备
     */
    private Equipment creatEquipment(int index) {

        int type = Integer.parseInt(EQUIPMENTS[index][0]);

        switch (type) {
            case PC:
                String model = EQUIPMENTS[index][1];
                String display = EQUIPMENTS[index][2];
                return new PC(model, display);
            case NOTEBOOK:
                model = EQUIPMENTS[index][1];
                double price = Double.parseDouble(EQUIPMENTS[index][2]);
                return new NoteBook(model, price);
            case PRINTER:
                String name = EQUIPMENTS[index][1];
                String printerType = EQUIPMENTS[index][2];
                return new Printer(name, printerType);
        }

        return null;
    }

    /**
     * 获取所有的员工
     * @return
     */
    public Employee[] getAllEmployees() {
        return employees;
    }

    /**
     * 获取指定员工
     * @return
     */
    public Employee getEmployee(int id) throws TeamException {
        for (int index = 0; index < employees.length; index++) {
            if (employees[index].getId() == id) {
                return employees[index];
            }
        }

        throw new TeamException("找不到指定的员工!");
    }


}
