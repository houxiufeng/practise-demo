package com.example.demo.suanfa;

/**
 * 完全二叉树：简而言之，就是从左到右结点是连续不断的二叉树就叫完全二叉树
 */

import com.example.demo.utils.TestUtils;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * https://cloud.tencent.com/developer/article/1842254
 * 堆排序demo
 * 顺序存储二叉树 特点:
 * 第 n 个元素的 左子节点 为 「2*n+1」
 * 第 n 个元素的 右子节点 为 「2*n+2」
 * 第 n 个元素的 父节点 为 「(n-1)/2」
 * 最后一个非叶子节点为 「Math.floor(arr.length/2)-1」
 *
 * 堆是具有以下性质的完全二叉树：
 * 大顶堆：每个节点的值都 「大于或等于」 其左右孩子节点的值
 * 注：「没有要求左右值的大小关系」
 * 小顶堆：每个节点的值都 「小于或等于」 其左右孩子节点的值
 *
 * top k问题，就是排名第K高的数字是几。排除掉末尾的k-1个数字，剩下数组前面的应该就是一个大顶堆
 * 例如：
 * 原始数组：[96, 66, 34, 99, 40, 72, 10, 75, 78, 82, 19, 84, 85, 21, 24, 91, 60, 61, 94, 95]
 * TOP4的数组：[94, 91, 85, 78, 82, 84, 24, 75, 61, 40, 19, 34, 72, 21, 10, 66, 60, 95, 96, 99]
 * 首位94就是第4大的数字，因为前3大95，96，99已经被排到末尾了。
 *
 * 同理：top4最小
 * origin:[64, 32, 2, 36, 37, 71, 9, 41, 13, 79, 50, 18, 53, 22, 55, 26, 90, 28, 94, 63]
 * sorted:[94, 90, 79, 71, 64, 63, 55, 53, 50, 41, 37, 36, 32, 28, 26, 22, 18, 13, 9, 2]
 * lowerK:[18, 26, 22, 28, 37, 53, 55, 32, 36, 63, 50, 71, 79, 64, 94, 41, 90, 13, 9, 2]
 *
 * 解题步骤：1.写swap. 2.写Adjust. 3.buildHeap. 4. swapAndAdjust.
 */
public class HeapSort {
    public static void main(String []args){
//        int []arr = {9,8,7,6,5,4,3,2,1};
        int[] arr = TestUtils.intArray(20);
//        int[] arr = {2, 3, 67, 4, 36, 70, 7, 74, 44, 12, 77, 79, 16, 80, 49, 82, 51, 84, 86, 60};
//        System.out.println("origin:" + Arrays.toString(arr));
//        List<Integer> collect = Arrays.stream(arr).sorted().boxed().collect(Collectors.toList());
//        System.out.println("sorted:" + collect);
//        sort(arr, 8);
//        System.out.println("topK  :" + Arrays.toString(arr));

//        List<Integer> collect = Arrays.stream(arr).boxed().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
//        System.out.println("sorted:" + collect);
//        sort2(arr, 4);
//        System.out.println("lowerK:" + Arrays.toString(arr));

        List<Integer> collect = Arrays.stream(arr).sorted().boxed().collect(Collectors.toList());
        System.out.println("sorted:" + collect);
        int[] ints = topKs(arr, 5);
        System.out.println("topK  :" + Arrays.toString(ints));

    }

    private static void test(int i) {
        System.out.println(i);
    }

    /**
     * arr数组中找到前TopK的数字
     * 大顶堆 --> 升序
     */
    public static int[] topKs(int[] arr, int k){
        int heapSize = k;
        int[] heapBig = new int[k];
        for (int i = 0; i < heapSize; i++) {
            heapBig[i] = arr[i];
        }

        //1.构建小顶堆
        for(int i=heapSize/2-1;i>=0;i--){
            //从第一个非叶子结点从下至上，从右至左调整结构
            adjustHeap2(heapBig, i, heapSize);
        }

        for (int i = k; i < arr.length; i++) {
            if (arr[i] > heapBig[0]) {
                heapBig[0] = arr[i];
                adjustHeap2(heapBig, 0, heapSize);
            }
        }
        return heapBig;





    }

    public static void sort(int[] arr, int k){
        int heapSize = arr.length;
        //1.构建大顶堆
        for(int i=arr.length/2-1;i>=0;i--){
            //从第一个非叶子结点从下至上，从右至左调整结构
            adjustHeap(arr, i, heapSize);
        }
        //2.调整堆结构+交换堆顶元素与末尾元素
        for(int i=arr.length-1;i>=arr.length-k+1 ;i--){
            swap(arr,0,i);//将堆顶元素与末尾元素进行交换
            //顶点元素变化了，所以得调整
            adjustHeap(arr, 0, --heapSize);//重新对堆进行调整
        }

    }

    /**
     * lowest K
     * 小顶堆 --> 降序
     */
    public static void sort2(int[] arr, int k){
        int heapSize = arr.length;
        //1.构建小顶堆
        for(int i=arr.length/2-1;i>=0;i--){
            //从第一个非叶子结点从下至上，从右至左调整结构
            adjustHeap2(arr, i, heapSize);
        }
        //2.调整堆结构+交换堆顶元素与末尾元素
        for(int i=arr.length-1;i>=arr.length-k+1 ;i--){
            swap(arr,0,i);//将堆顶元素与末尾元素进行交换
            heapSize--;
            //顶点元素变化了，所以得调整
            adjustHeap2(arr, 0, heapSize);//重新对堆进行调整
        }

    }

    /**
     * 调整大顶堆（核心逻辑）
     * 视野放在其中的一个三节点二叉树上，其他的都是类似问题。
     * 重点：哪个节点变化了，那么这个节点再次调整，没变化的说明不用动。
     */
    public static void adjustHeap(int[] a, int i, int heapSize) {
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        int max = i;
        if (left < heapSize && a[left] > a[max]) {
            max = left;
        }
        if (right < heapSize && a[right] > a[max]) {
            max = right;
        }
        if (max != i) {
            swap(a, max, i);
            //重点：哪个节点变化了，那么这个节点再次调整，没变化的说明不用动。
            adjustHeap(a, max, heapSize);
        }
    }

    public static void adjustHeap2(int[] a, int i, int heapSize) {
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        int min = i;
        if (left < heapSize && a[left] < a[min]) {
            min = left;
        }
        if (right < heapSize && a[right] < a[min]) {
            min = right;
        }
        if (min != i) {
            swap(a, min, i);
            //重点：哪个节点变化了，那么这个节点再次调整，没变化的说明不用动。
            adjustHeap2(a, min, heapSize);
        }
    }

    /**
     * 交换元素
     * @param arr
     * @param a
     * @param b
     */
    public static void swap(int []arr,int a ,int b){
        int temp=arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
