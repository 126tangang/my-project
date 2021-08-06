package template;

/**
 * 模板方法设计模式
 */
public abstract class Template {
    /**
     * 计算某段代码花费的时间
     */
    public void spendTime() {
        long start = System.currentTimeMillis();

        code();

        long end = System.currentTimeMillis();

        System.out.println("花费的时间：" + (end - start));
    }

    /**
     * 某段代码
     */
    public abstract void code();
}
