import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lin
 * @date 2018/7/31 下午6:23
 * @description:
 */
public class Day11 {

    @Test
    public void tt() {
        List<Integer> list = new ArrayList<Integer>();
        list.add(1);
        list.add(2);
        list.add(3);

        List<Integer> list1 = null;
        for (Integer integer : list1) {
            System.out.println(integer);
        }
    }
}
