import java.util.Arrays;

public class Semi3 {
    public static void main(String[] args) {
        int[] inputArray = new int[]{6, 5, 1, 8,31,3,24,12,123,11,22,30};
        mergeSort(inputArray);
        System.out.println(Arrays.toString(inputArray));
    }

    static void mergeSort(int[] input) {
        if (input.length < 2){
            return;
        }
        int len = input.length;
        int[] lefttAr = new int[len/2];
        System.arraycopy(input,0,lefttAr,0,len/2);
        int[] rightAr = new int[len-len/2];
        System.arraycopy(input,len/2 , rightAr,0, len - (len/2));
        mergeSort(lefttAr);
        mergeSort(rightAr);
        merge(input,rightAr,lefttAr);
    }
    static void merge(int[] res, int[] rightAr, int[] lefttAr) {
        int l = 0;
        int r = 0;
        int resUk = 0;
        while (r<rightAr.length & l<lefttAr.length){
            if(rightAr[r] <= lefttAr[l]){
                res[resUk] = rightAr[r];
                r++;
                resUk++;
            } else {
                res[resUk] = lefttAr[l];
                resUk++;
                l++;
            }
        }
        while (r<rightAr.length){
            res[resUk] = rightAr[r];
            r++;
            resUk++;
        }
        while (l<lefttAr.length) {
            res[resUk] = lefttAr[l];
            resUk++;
            l++;
        }

    }
}
