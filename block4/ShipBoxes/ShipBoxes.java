//package block4.ShipBoxes;

import java.util.ArrayList;
import java.util.List;

public class ShipBoxes {
    int bestCost(int[] box1, int[] box2) {
        int min = Integer.MAX_VALUE;
        List<List<Integer>> list1 = generatePermutations(box1);
        List<List<Integer>> list2 = generatePermutations(box2);
        for (List<Integer> l1 : list1) {
            for (List<Integer> l2: list2) {
                int l = l1.get(0) + l2.get(0);
                int w = Math.max(l1.get(1), l2.get(1));
                int h = Math.max(l1.get(2), l2.get(2));
                int area = cal_cardboard_area(l, w, h);
                min = Math.min(min, area);

                l = Math.max(l1.get(0), l2.get(0));
                w = l1.get(1) +  l2.get(1);
                h = Math.max(l1.get(2), l2.get(2));
                area = cal_cardboard_area(l, w, h);
                min = Math.min(min, area);

                l = Math.max(l1.get(0), l2.get(0));
                w = Math.max(l1.get(1), l2.get(1));
                h = l1.get(2) + l2.get(2);
                area = cal_cardboard_area(l, w, h);
                min = Math.min(min, area);
            }
        }
        return min;
    }

    public int cal_cardboard_area(int l, int w, int h) {
        return 2 * (l * w + w * h + h * l) + 2 * (l * h);
    }

    public void permute(int[] arr, int start, List<List<Integer>> result) {
        if (start == arr.length) {
            List<Integer> permutation = new ArrayList<>();
            for (int num : arr) {
                permutation.add(num);
            }
            result.add(permutation);
        } else {
            for (int i = start; i < arr.length; i++) {
                swap(arr, start, i);
                permute(arr, start + 1, result);
                swap(arr, start, i);
            }
        }
    }

    public void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    // Main function to generate permutations
    public List<List<Integer>> generatePermutations(int[] arr) {
        List<List<Integer>> result = new ArrayList<>();
        permute(arr, 0, result);
        return result;
    }

    public static void main(String[] args) {
        int[] a = {1,4,9};
        int[] b = {1,4, 9};
        System.out.println(new ShipBoxes().bestCost(a, b));
    }
}
