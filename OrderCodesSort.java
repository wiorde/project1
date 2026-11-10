import java.util.Arrays;

public class OrderCodesSort {
    public static void main(String[] args) {
        int[] arr={314159,271828,123456};
        radixSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void radixSort(int[] arr) {
        if(arr.length==0)return;
        int max=arr[0];
        for(int val:arr){
            if(val>max)max=val;
        }
        for(int exp=1;max/exp>0;exp*=10){
            countingSortByDigit(arr,exp);
        }
    }

    private static void countingSortByDigit(int[] arr,int exp) {
        int n=arr.length;
        int[] output=new int[n];
        int[] count=new int[10];
        for(int i=0;i<n;i++){
            count[(arr[i]/exp)%10]++;
        }
        for(int i=1;i<10;i++){
            count[i]+=count[i-1];
        }
        for(int i=n-1;i>=0;i--){
            output[count[(arr[i]/exp)%10]-1]=arr[i];
            count[(arr[i]/exp)%10]--;
        }
        for(int i=0;i<n;i++){
            arr[i]=output[i];
        }
    }
}