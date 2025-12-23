package algo;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();


        for (int i = 0; i < nums.length; i++) {
            Integer j = map.get(target - nums[i]);
            if (j == null) {
                map.put(nums[i], i);
            } else {
                return new int[]{j, i};
            }
        }


        return new int[0];
    }
    public int[] twoSum1(int[] nums, int target) {
        int i = 0;
        int j = nums.length - 1;
        int sum = 0;

        while (i < j) {
            sum = nums[i] + nums[j];

            if (sum == target) { return new int[]{i, j}; }
            if (sum > target) {
                j--;
            } else {
                i++;
            }
        }


        return new int[0];
    }
}

//Дан массив целых чисел nums и целое число target.
// Необходимо вернуть индексы двух чисел из массива так,
// чтобы их сумма была равна target.
//        Можно считать, что для каждого входного набора
//        данных существует ровно одно решение, и один
//        и тот же элемент нельзя использовать дважды.
//Ответ можно вернуть в любом порядке.

//Пример 2:
//Ввод: nums = [3, 2, 8, 3], target = 6
//2 3 3 8
//Вывод: [1, 2]

