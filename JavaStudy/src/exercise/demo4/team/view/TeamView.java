package exercise.demo4.team.view;

import exercise.demo4.team.domain.Employee;
import exercise.demo4.team.domain.Programmer;
import exercise.demo4.team.service.NameListService;
import exercise.demo4.team.service.TeamException;
import exercise.demo4.team.service.TeamService;
import exercise.demo4.team.utility.TSUtility;

public class TeamView {
    private NameListService nameListService = new NameListService();
    private TeamService teamService = new TeamService();

    public void enterMainMenu() {

        boolean flag = true;
        char menuSelection = 0;

        while (flag) {
            if (menuSelection != '1'){
                listAllEmployees();
            }

            System.out.print("1-团队列表 2-添加团队成员 3-删除团队成员 4-退出 请选择(1-4):");
            menuSelection = TSUtility.readMenuSelection();

            switch (menuSelection) {
                case '1':
                    getTeam();
                    break;
                case '2':
                    addMember();
                    break;
                case '3':
                    deleteMember();
                    break;
                case '4':
                    System.out.print("确认是否退出(Y/N):");
                    char confirmSelection = TSUtility.readConfirmSelection();
                    if (confirmSelection == 'Y') {
                        flag = false;
                    }
                    break;
            }
        }
    }

    /**
     * 显示所有员工信息
     */
    private void listAllEmployees() {
        System.out.println("\n-------------------------------开发团队调度软件--------------------------------\n");

        Employee[] employees = nameListService.getAllEmployees();
        if (employees == null || employees.length == 0) {
            System.out.println("公司没有任何员工信息!");
        } else {
            System.out.println("ID\t姓名 \t年龄\t工资    \t\t职位  \t状态 \t奖金    \t\t股票  \t领用设备");
            for (Employee employee : employees) {
                System.out.println(employee);
            }
        }

        System.out.println("-------------------------------------------------------------------------------");
    }

    /**
     * 显示团队列表
     */
    private void getTeam() {
        System.out.println("\n--------------------团队成员列表---------------------\n");

        Programmer[] programmers = teamService.getTeam();
        if (programmers == null || programmers.length == 0) {
            System.out.println("开发团队目前没有成员!");
        } else {
            System.out.println("TID/ID\t姓名    \t年龄    \t工资    \t\t职位    \t奖金    \t\t股票");
            for (Programmer programmer : programmers) {
                System.out.println(programmer.getDetailsForTeam());
            }
        }

        System.out.println("-----------------------------------------------------");
    }

    /**
     * 添加团队成员
     */
    private void addMember() {
        System.out.println("---------------------添加成员---------------------");
        System.out.print("请输入要添加的员工ID：");
        int id =TSUtility.readInt();
        try {
            Employee employee = nameListService.getEmployee(id);
            teamService.addMember(employee);
            System.out.println("添加成功!");
        } catch (TeamException e) {
            System.out.println("添加失败,原因:" + e.getMessage());
        }
        /* 按回车键继续 */
        TSUtility.readReturn();
    }

    /**
     * 删除团队成员
     */
    private void deleteMember() {
        System.out.println("---------------------删除成员---------------------");
        System.out.print("请输入要删除员工的TID：");
        int memberId = TSUtility.readInt();
        System.out.print("确认是否删除(Y/N)：");
        char confirmSelection = TSUtility.readConfirmSelection();
        if (confirmSelection == 'N') {
            return;
        }

        try {
            teamService.removeMember(memberId);
            System.out.println("删除成功!");
        } catch (TeamException e) {
            System.out.println("删除失败,原因：" + e.getMessage());
        }
        /* 按回车键继续 */
        TSUtility.readReturn();
    }

}
