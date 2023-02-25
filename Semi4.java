import java.util.Arrays;

public class Semi4 {
    static void sorting(int[] arr) {
        int len = arr.length;
        for (int i = len / 2 - 1; i >= 0; i--) {
            createHeap(arr, len, i);
        }
        for (int i = len - 1; i >= 0; i--) {
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            createHeap(arr, i, 0);
        }
    }

    public static void main(String[] args) {
        int[] array = {32, 524, 3, 65, 43, 3, 5, 7, 7, 5, 43, 3, 25, 5, 4};
        sorting(array);
        System.out.println(Arrays.toString(array));
    }

    static void createHeap(int[] arr, int len, int index) {
        int max = index;
        int left = 2 * index + 1;
        int right = 2 * index + 2;
        if (left < len && arr[left] > arr[max]) {
            max = left;
        }
        if (right < len && arr[right] > arr[max]) {
            max = right;
        }
        if (max != index) {
            int temp = arr[index];
            arr[index] = arr[max];
            arr[max] = temp;
            createHeap(arr, len, max);
        }
    }
}
