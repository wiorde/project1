import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class VotesShareSort {
    public static void main(String[] args) {
        double[] arr={0.25,0.70,0.10,0.90};
        bucketSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void bucketSort(double[] arr) {
        if(arr.length==0)return;
        int n=arr.length;
        List<List<Double>> buckets=new ArrayList<>(n);
        for(int i=0;i<n;i++){
            buckets.add(new ArrayList<>());
        }
        for(double val:arr){
            int index=(int)(val*n);
            if(index==n)index--;
            buckets.get(index).add(val);
        }
        int index=0;
        for(List<Double> bucket:buckets){
            insertionSort(bucket);
            for(double val:bucket){
                arr[index++]=val;
            }
        }
    }

    private static void insertionSort(List<Double> bucket) {
        for(int i=1;i<bucket.size();i++){
            double key=bucket.get(i);
            int j=i-1;
            while(j>=0&&bucket.get(j)>key){
                bucket.set(j+1,bucket.get(j));
                j--;
            }
            bucket.set(j+1,key);
        }
    }
}
