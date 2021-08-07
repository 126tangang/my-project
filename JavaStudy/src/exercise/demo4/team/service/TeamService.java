package exercise.demo4.team.service;

import exercise.demo4.team.domain.Architect;
import exercise.demo4.team.domain.Designer;
import exercise.demo4.team.domain.Employee;
import exercise.demo4.team.domain.Programmer;

/**
 * 关于开发团队的管理:添加,删除等
 */
public class TeamService {

    private static int counter = 1;/* 给memberId赋值使用 */
    private final int MAX_MEMBER = 5;/* 限制开发团队的人数 */
    private Programmer[] programmers = new Programmer[MAX_MEMBER];/* 保存开发团队成员 */
    private int total = 0;/* 记录开发团队中实际的人数 */

    /**
     * 获取开发团队中所有的成员
     * @return  Programmer[]
     */
    public Programmer[] getTeam() {
        Programmer[] programmers = new Programmer[total];
        for (int index = 0; index < total; index++) {
            programmers[index] = this.programmers[index];
        }
        return programmers;
    }

    /**
     * 添加成员
     * @param employee 待添加的员工
     * @throws TeamException 自定义异常
     */
    public void addMember(Employee employee) throws TeamException {
        /* 成员已满,无法添加 */
        if (total >= MAX_MEMBER) {
            throw new TeamException("成员已满,无法添加!");
        }
        /* 该成员不是开发成员,无法添加! */
        if (!(employee instanceof Programmer)) {
            throw new TeamException("该成员不是开发成员,无法添加!");
        }
        /* 该员工已在本开发团队中! */
        if (isExit(employee)) {
            throw new TeamException("该员工已在本开发团队中!");
        }
        /*
         * 1.该员工已是某团队成员
         * 2.该员工正在休假无法添加
         */
        Programmer programmer = (Programmer) employee;
        if ("BUSY".equalsIgnoreCase(programmer.getStatus().getNAME())) {
            throw new TeamException("该员工已是某团队成员!");
        } else if ("VOCATION".equalsIgnoreCase(programmer.getStatus().getNAME())) {
            throw new TeamException("该员工正在休假,无法添加!");
        }
        /* 获取已有成员中架构师,设计师,程序员的人数 */
        int numberOfArchitecture = 0;
        int numberOfDesigner = 0;
        int numberOfProgrammer = 0;
        for (int index = 0; index < total; index++) {
            if (programmers[index] instanceof Architect) {
                numberOfArchitecture++;
            } else if (programmers[index] instanceof Designer) {
                numberOfDesigner++;
            } else if (programmers[index] instanceof Programmer) {
                numberOfProgrammer++;
            }
        }

        if (programmer instanceof Architect) {/* 团队中至多只能有一名架构师 */
            if (numberOfArchitecture >= 1) {
                throw new TeamException("团队中至多只能有一名架构师!");
            }
        } else if (programmer instanceof Designer) {/* 团队中至多只能有两名设计师 */
            if (numberOfDesigner >= 2) {
                throw new TeamException("团队中至多只能有两名设计师!");
            }
        } else if (programmer instanceof Programmer) {/* 团队中至多只能有三名程序员 */
            if (numberOfProgrammer >= 3) {
                throw new TeamException("团队中至多只能有三名程序员!");
            }
        }

        /* 满足条件,将该成员添加到现有团队中 */
        programmers[total++] = programmer;
        /* 修改该成员状态 */
        programmer.setStatus(Status.BUSY);
        /* 设置该成员MemberId */
        programmer.setMemberId(counter++);

    }

    /**
     * 删除成员
     * @param MemberId  待删除的员工
     * @throws TeamException 自定义异常
     */
    public void removeMember(int MemberId) throws TeamException {
        int index;
        for (index = 0; index < total; index++) {
            if (programmers[index].getMemberId() == MemberId) {
                programmers[index].setStatus(Status.FREE);
                /*
                 * 此处需要先跳出循环，再删除数组中的元素,因为删除数组中的元素后会让total会减1
                 * 此时外层for循环的total就就随之减1,毫无疑问会影响循环
                 * 如果你此时恰巧删除的是数组中最后一个元素,就会出bug,比如数组长度为5,此时最后一个元素索引为index==4
                 * 删除后total-1==4,循环刚好结束,且index==total,就会执行循环外的判断语句,抛出异常,显示删除失败
                 * 但当你打印团队列表时,又显示你已经删除了该名成员,以后千万别问是怎样发现这么恶心的bug！！！
                 */
                break;
            }
        }
        if (index == total) {
            throw new TeamException("该员工不存在 ,删除失败!");
        }
        for (int j = index; j < total - 1; j++) {
            programmers[j] = programmers[j + 1];
        }
        programmers[total - 1] = null;
        total--;
    }

    /**
     * 判断指定的员工是否存在于现有的开发团队中
     * @param employee
     * @return
     */
    private boolean isExit(Employee employee) {
        for (int index = 0; index < total; index++) {
            if (programmers[index].getId() == employee.getId()) {
                return true;
            }
        }
        return false;
    }
}
