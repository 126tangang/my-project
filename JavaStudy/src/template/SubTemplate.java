package template;

public class SubTemplate extends Template {

    /**
     * 某段代码
     */
    @Override
    public void code() {
        int n = 1000;
        for (int i = 2; i < n; i++) {
            boolean flag = true;
            for (int j = 2; j < Math.sqrt(i); j++) {
                if (i % j == 0) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                System.out.println(i);
            }
        }
    }
}
