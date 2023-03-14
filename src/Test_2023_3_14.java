public class Test_2023_3_14 {


    // 手写一个快速排序


    public static void main(String[] args) {
        int[] arr = {12,23,21,54,32,15,76};
//        quickSort(arr,0,arr.length-1);

//        heapSorted(arr);

        // 归并排序
//        guibingSorted(arr);

//        bubbleSorted(arr);

        // 直接插入排序
//        insertSorted(arr);

        // 选择排序
//        selectSorted(arr);


        for (int i = 0; i <arr.length ; i++) {
            System.out.println(arr[i]);
        }
    }

//    private static void selectSorted(int[] arr) {
//        for (int i = 0; i < arr.length; i++) {
//            for (int j = i+1; j < arr.length; j++) {
//                if(arr[j]<arr[i]){
//                    swap(arr, i,j );
//                }
//            }
//        }
//    }

//    private static void insertSorted(int[] arr) {
//        for (int i = 1; i < arr.length; i++) {
//            int tmp = arr[i];
//            int j = i-1;
//            for (; j >=0 ; j--) {
//                if(arr[j]>=tmp){
//                    arr[j+1] = arr[j];
//                }else{
//                    break;
//                }
//            }
//            arr[j+1] = tmp;
//        }
//    }


    private static void bubbleSorted(int[] arr) {
        for (int i = 0; i <arr.length ; i++) {
            boolean flg = true;
            for (int j = 0; j <arr.length-1-i ; j++) {
                if(arr[j]>arr[j+1]){
                    swap(arr,j,j+1);
                    flg = false;
                }
            }

            if(flg){
                break;
            }
        }
    }

    private static void swap(int[] arr, int j, int i) {
         int tmp = arr[i];
         arr[i] = arr[j];
         arr[j] = tmp;
    }

//    private static void guibingSorted(int[] arr) {
//          guibingSortedInternal(arr,0,arr.length-1);
//    }
//
//    private static void guibingSortedInternal(int[] arr, int start, int end) {
//         if(start>=end){
//             return;
//         }
//         int mid = (start+end)/2;
//        // 先分治
//        guibingSortedInternal(arr,start,mid);
//        guibingSortedInternal(arr,mid+1, end);
//        // 在合并
//        merge(arr,start,mid,end);
//    }
//
//    private static void merge(int[] arr, int start, int mid, int end) {
//        int s1 = start;
//        int e1 = mid;
//        int s2 = mid+1;
//        int e2 = end;
//        int[] tmp =new int[e2-s1+1];
//        int k =0;
//
//        // 合并有序数组
//        while(s1<=e1 && s2<=e2){
//            if(arr[s1]<arr[s2]){
//                tmp[k++] = arr[s1++];
//            }else{
//                tmp[k++] = arr[s2++];
//            }
//        }
//
//        while(s1<=e1){
//            tmp[k++] =arr[s1++];
//        }
//
//        while(s2<=e2){
//            tmp[k++] = arr[s2++];
//        }
//
//        for (int j = 0; j < tmp.length; j++) {
//            arr[start+j] = tmp[j];
//        }
//    }

//    private static void heapSorted(int[] arr) {
//        createHeap(arr);
//        // 首尾元素进行交换，从0下标重新进行向下调整。
//        int start = 0;
//        int end = arr.length-1;
//        // 没交换一次完成一次最大的排到后边
//        while(end>0){
//            int tmp = arr[end];
//            arr[end] = arr[start];
//            arr[start] = tmp;
//            adjustDown(arr, start, end);
//            end--;
//        }
//    }
//
//    private static void createHeap(int[] arr) {
//          //将数组变成一个大根堆
//        for (int i = (arr.length-1-1)/2; i >=0 ; i--) {
//            adjustDown(arr,i,arr.length);
//        }
//    }
//
//    // 向下调整
//    private static void adjustDown(int[] arr, int i, int length) {
//        int root = i;
//        int child = 2*root+1;
//        while(child<length){
//            // 保证arr[child] 一定是左右孩子节点中最大的孩子节点
//            if(child+1<length && arr[child]<arr[child+1]){
//                child++;
//            }
//            // 跟父亲节点进行比较，如果小的话进行交换重新调整
//            if(arr[child]>arr[root]){
//                int tmp = arr[root];
//                arr[root] = arr[child];
//                arr[child] = tmp;
//                root = child;
//                child=2*root+1;
//            }else{
//                break;
//            }
//        }
//    }



//    private static void quickSort(int[] arr,int start,int end) {
//        if(start>=end){
//            return;
//        }
//
//        // 首先用挖坑法将首个元素放到合适的位置，左半边全是比他小的元素，右半边全是比他大的元素
////        int pivot = partition(arr,start,end);
////        quickSort(arr,start,pivot-1);
////        quickSort(arr,pivot+1,end);
//
//        // 将这个元素左边的元素进行递归，右边进行递归
//    }

//    private static int partition(int[] arr, int start, int end) {
//        int tmp = arr[start];
//        while(start<end){
//            while(start<end && arr[end]>tmp){
//                end--;
//            }
//            arr[start] = arr[end];
//            while(start<end && arr[start]<=tmp){
//                start++;
//            }
//            arr[end] = arr[start];
//        }
//        arr[start] = tmp;
//        return start;
//    }

}
