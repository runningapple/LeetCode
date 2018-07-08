package sort;

/**
 * @author lin
 * @date 2018/7/6 上午10:02
 * @description: 归并排序数组实现
 */
public class MergeSort {

    private static void merge(int[] array, int begin, int mid, int end) {
        int[] tmpArray = new int[end - begin + 1];
        int leftIndex = begin;
        int rightIndex = mid + 1;
        int tmpIndex = 0;
        while (leftIndex <= mid && rightIndex <= end) {
            if (array[leftIndex] < array[rightIndex]) {
                tmpArray[tmpIndex] = array[leftIndex++];
            } else {
                tmpArray[tmpIndex] = array[rightIndex++];
            }
            ++tmpIndex;
        }
        while (leftIndex <= mid) {
            tmpArray[tmpIndex++] = array[leftIndex++];
        }
        while (rightIndex <= end) {
            tmpArray[tmpIndex++] = array[rightIndex++];
        }
        System.arraycopy(tmpArray, begin, array, begin, end - begin + 1);
    }

    private static void sort(int[] array, int begin, int end) {
        if (begin < end) {
            int mid = (begin + end) >> 1;
            sort(array, begin, mid);
            sort(array, mid + 1, end);
            merge(array, begin, mid, end);
        }
    }

    public static void main(String[] args) {
        int[] arr = {5, 3, 2};
        sort(arr, 0, 2);
        System.out.println(arr[0] + " " + arr[1] + " " + arr[2]);
    }

}
