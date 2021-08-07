package exercise.demo4.team.service;

/**
 * 自定义异常类
 */
public class TeamException extends Exception{
    static final long serialVersionUID = -33875169234229948L;

    public TeamException() {

    }

    public TeamException(String msg) {
        super(msg);
    }
}
