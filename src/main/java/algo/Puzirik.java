package algo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Puzirik {
    public static void main(String[] args) {

        List<Integer> list = Arrays.asList(5, 1, 8, 2, 7, 3, 4, 6, 9, 12);
        boolean sort = false;
        boolean flag = false;
        int i = 0;
        int tmp;
        int listSize = list.size();

        while (!sort) {
            if (i == 0) {
                flag = false;
            }
            int ii = list.get(i);
            int jj = list.get(i + 1);
            if (list.get(i) > list.get(i + 1)) {
                tmp = list.get(i);
                list.set(i, list.get(i + 1));
                list.set(i + 1, tmp);
                flag = true;
            }
            i++;
            if (i == listSize - 1) {
                i = 0;
                if (!flag) {
                    sort = true;
                }
            }
        }
        System.out.println(list);
    }
}
