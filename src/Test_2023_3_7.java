import com.sun.scenario.animation.shared.ClipEnvelope;

public class Test_2023_3_7 {
     // 直接插入排序
     public static void main(String[] args) {
       while(true){
           System.out.println(1);
       }

//         int[] a = {23,34,65,32,54,23,87,12};
////         insertSort(a);
//         //shellSorted(a);
//         //bubbleSorted(a);
////        selectSored(a);
//
//         duiSorted(a);
//
//         for (int i = 0; i < a.length; i++) {
//             System.out.println(a[i]);
//         }
     }

     public static void siftDown(int[] arr,int root, int length){
         int parent = root;
         int child = 2*parent+1;

         while(child<length){
             // 让arr[child] 所指向的孩子节点是左右孩子中最大的
             if(child+1<length && arr[child]<arr[child+1]){
                 child++;
             }

             // 此时孩子节点 与 父亲节点 进行比较
             if(arr[parent]<arr[child]){
                 int tmp = arr[child];
                 arr[child] = arr[parent];
                 arr[parent] = tmp;

                 parent = child;
                 child = 2*parent+1;
             }else{
                 // 不大于的话，说明这颗子树已经调整完毕了
                 break;
             }
         }
     }

    private static void duiSorted(int[] a) {
          // 现将数组转换成一个大根堆
        for (int i = (a.length-1-1)/2; i >=0; i--) {
            siftDown(a,i,a.length);
        }

        // 然后将数组的首尾元素进行交换，交换完之后再次进行向下调整
        int start = 0;
        int end = a.length-1;
        while(end>=0){
            int tmp = a[start];
            a[start] = a[end];
            a[end] = tmp;


            siftDown(a, start, end);
            end--;

        }
     }

//     public  static  void selectSored(int[] a){
//         for (int i = 0; i < a.length; i++) {
//             for (int j = i+1; j < a.length; j++) {
//                 if(a[j]<a[i]){
//                     int tmp = a[i];
//                     a[i] = a[j];
//                     a[j] = tmp;
//                 }
//             }
//         }
//     }

//     public static void bubbleSorted(int[] a){
//         for (int i = 0; i < a.length; i++) {
//             boolean flg = false;
//             for (int j = 0; j < a.length-1-i; j++) {
//                 if(a[j]>a[j+1]){
//                     int tmp = a[j+1];
//                     a[j+1] = a[j];
//                     a[j] = tmp;
//                     flg = true;
//                 }
//             }
//
//             if(!flg){
//                 break;
//             }
//         }
//     }
     
     public static void bubbleSorted1(int[] a){
         for (int i = 0; i < a.length; i++) {
             boolean flg = false;
             for (int j = 0; j <a.length-1-i ; j++) {
                 if(a[j+1]<a[j]){
                     int tmp = a[j];
                     a[j] = a[j+1];
                     a[j+1] = tmp;
                     flg = true;
                 }
             }

             if(!flg){
                 break;
             }
         }
     }

    private static void shellSorted(int[] a) {
         int gap = a.length;
         while(gap>1){
             gap = gap/3+1;
             shell(a, gap);
         }
    }

    private static void shell(int[] a, int gap) {
        for (int i = gap; i < a.length; i++) {
            int tmp = a[i];
            int j = i-gap;
            for (; j >=0 ; j-=gap) {
                if(tmp<=a[j]){
                    a[j+gap] = a[j];
                }else{
                    break;
                }
            }
            a[j+gap] = tmp;
        }
    }

//    private static void insertSort(int[] a) {
//        for (int i = 1; i < a.length; i++) {
//            int tmp = a[i];int j = i-1;
//            for (; j>=0; j--) {
//                if(tmp<=a[j]){
//                   a[j+1] = a[j];
//                }else{
//                    break;
//                }
//            }
//            a[j+1] = tmp;
//        }
//    }


    // 直接插入算法


    private static void  insertSort1(int[] a) {
        for (int i = 1; i <a.length ; i++) {
            int j= i-1;
            int tmp = a[i];
            for (; j >=0 ; j--) {

                if(tmp<a[j]){
                    a[j+1] = a[j];
                }else{
                    break;
                }
            }
            a[j+1] = tmp;
        }
    }

}
