import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.PriorityQueue;

public class Test_2023_3_10 {

    public static void main(String[] args) {

        Comparator<Integer> comparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1-o2;
            }
        };

        PriorityQueue priorityQueue =new PriorityQueue(comparator);

        PriorityQueue<Integer> priorityQueue1 = new PriorityQueue<>((o1,o2)->{return o1-o2;});
        priorityQueue1.offer(1);
        priorityQueue1.offer(2);
        priorityQueue1.offer(3);
        priorityQueue1.offer(4);
        priorityQueue1.offer(5);
        Iterator<Integer> iterator = priorityQueue1.iterator();
        while(iterator.hasNext()) {
            System.out.println(iterator.next());
        }

       int[] arr  = {12,32,65,34,23,65,23,575};

       heapSort(arr);

        long t1 = System.currentTimeMillis();
        //quickSorted(arr,0, arr.length-1);


        //mergeSort(arr);

        heapSort(arr);
         long t2 = System.currentTimeMillis();

        System.out.println(t2-t1);

        System.out.println(Arrays.toString(arr));

    }

    private static void heapSort(int[] arr) {

        // 升序的化
         // 1、先将数组转化成大堆
        createHeap(arr);

        int end= arr.length-1;
        int start = 0;
        // 首尾交换
        while(end>=0){
            int tmp = arr[end];
            arr[end] = arr[start];
            arr[start] = tmp;
            // 重新调整为大根堆
            adjustDown(arr, start, end);
            end--;
        }



    }

    private static void createHeap(int[] arr) {
        for (int i = (arr.length-1-1)/2;i>=0; i--) {
          adjustDown(arr, i,arr.length);
        }
    }

    public static void adjustDown(int[] arr, int root,int len){
        int parent =root;
        int child = 2*parent+1;
        while(child<len){
            if(child+1<len && arr[child]<arr[child+1]){
                child++;
            }
            // 比较孩子节点和父亲节点的大小
            if(arr[parent]<arr[child]){
                int tmp = arr[parent];
                arr[parent] = arr[child];
                arr[child] = tmp;

                parent = child;
                child = 2*parent+1;
            }else{
                break;
            }
        }
    }


    private static void mergeSort(int[] arr) {
         mergeSortInternal(arr,0,arr.length-1);
    }

    private static void mergeSortInternal(int[] arr, int start, int end) {
        if(start>=end){
            return;
        }

        // 先分解

        int mid = (start+end)/2;
        mergeSortInternal(arr,start,mid);
        mergeSortInternal(arr,mid+1,end);

        // 在合并
        merge(arr,start,mid,end);
    }

    private static void merge(int[] arr, int start, int mid, int end) {
        int s1 = start;
        int e1 = mid;
        int s2 = mid+1;
        int e2 = end;
        int[] tmp = new int[end-start+1];
        int k = 0;
        while(s1<=e1 && s2<=e2){
            if(arr[s1]<arr[s2]){
                tmp[k++] = arr[s1++];
            }else{
                tmp[k++] = arr[s2++];
            }
        }

        while(s1<=e1){
            tmp[k++] = arr[s1++];
        }

        while(s2<=e2){
            tmp[k++] = arr[s2++];
        }

        for (int i = 0; i < tmp.length; i++) {
            arr[start+i] = tmp[i];
        }
    }

    private static void quickSorted(int[] arr,int start,int end) {
         if(start>=end){
             return;
         }

       //   范围区间缩小到一定的范围之后，达到一定的有序性，可以使用直接插入排序缩小空间复杂度
         if(end+1-start<100){
             for(int i = start+1;i<=end;i++){
                 int j = i-1;
                 int tmp = arr[i];
                 for (; j >=start ; j--) {
                     if(tmp<arr[j]){
                         arr[j+1] = arr[j];
                     }else{
                         break;
                     }
                 }
                 arr[j+1] = tmp;
             }
         }

         int pivot = partiton(arr,start, end);
         quickSorted(arr, start, pivot-1);
         quickSorted(arr, pivot+1, end);
    }

    private static int partiton(int[] arr, int start,int end) {

        selectOfThree(arr,start,end);

        int tmp = arr[start];
        while(start<end){
             while(start<end && tmp<=arr[end]){
                 end--;
             }
             arr[start] = arr[end];

             while(start<end && tmp>=arr[start]){
                 start++;
             }
             arr[end] = arr[start];
        }

        arr[start] =tmp;

        return start;
    }

    private static void selectOfThree(int[] arr, int start, int end) {
            //arr[mid]<= arr[start] <= arr[end]

        int mid = (start+end)/2;

        if(arr[start]<arr[mid]){
            int tmp  = arr[start];
            arr[start] = arr[mid];
            arr[mid] = tmp;
        }

        if(arr[start]>arr[end]){
            int tmp  = arr[start];
            arr[start] = arr[end];
            arr[end] = tmp;
        }
    }


}
