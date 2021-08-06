package exercise.demo1;

/**
 * 比较两个对象的大小。
 */
public interface CompareObject {
    /**
     *  若返回值是0，代表相等；若为正数，代表当前对象大；若为负数，代表当前对象小。
     * @param object
     * @return  int
     */
    public int compareTo(Object object) throws Exception;
}
