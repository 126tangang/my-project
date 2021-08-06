package exercise.demo1;

/**
 * 比较两个圆半径的大小。
 */
public class ComparableCircle extends Circle implements CompareObject {

    public ComparableCircle() {

    }

    public ComparableCircle(double radius) {
        super(radius);
    }

    /**
     * 若返回值是0，代表相等；若为正数，代表当前对象大；若为负数，代表当前对象小。
     *
     * @param object
     * @return int
     */
    @Override
    public int compareTo(Object object) {
        if (this == object) {
            return 0;
        }
        if (object instanceof Circle) {
            Circle circle = (Circle) object;
            if (circle.getRadius() < this.getRadius()) {
                return -1;
            } else if (circle.getRadius() > this.getRadius()) {
                return 1;
            }
            return 0;
        } else {
            throw new RuntimeException("参数匹配错误！");
        }
    }
}
