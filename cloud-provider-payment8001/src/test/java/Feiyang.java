import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;


public class Feiyang {
    @Test
    public void demo2(){
        System.out.println(666);
    }
    @Test
    public void demo1(){
        Integer[] arr={6,1,2,7,9,3,4,5,8};
//        Integer[] arr={3,5,1,2};
        QuickSort.sort(arr);
        System.out.println(Arrays.toString(arr));//把数组转换为字符串
    }
    public static class QuickSort {

        /*
        比较v元素是否小于w元素
         */
        private static boolean less(Comparable v,Comparable w){//当v>w时，结果为true
            return v.compareTo(w)<0;
        }

        /*
        数组元素i和j交换位置
         */
        private static void exch(Comparable[] a,int i,int j){
            Comparable t=a[i];
            a[i]=a[j];
            a[j]=t;
        }

        //对数组内的元素进行排序
        //这个是我们的sort方法
        public static void sort(Comparable[] a){
            int lo = 0;
            int hi=a.length -1;
            sort(a,lo,hi);//调用sort方法的重载方法
        }

        //对数组a从索引lo到索引hi之间的元素进行排序
        //这个是我们的sort方法的重载方法
        private static void sort(Comparable[] a, int lo, int hi) {
            //安全性校验
            if(hi<=lo){
                return;
            }
            //需要对数组中lo索引到hi索引处的元素进行分组（左子组和右子组）
            int partition=partition(a,lo,hi);//返回的是分组的分界值所在的索引，分界值位置变换后的索引
            //让左子组有序
            sort(a,lo,partition-1);
            //让右子组有序
            sort(a,partition+1,hi);
        }

        //对数组a中，从索引lo到索引hi之间的元素进行分组，并返回分组界限对应的索引
        public static int partition(Comparable[] a,int lo,int hi){
            //确定分界值，我们这里就是把最左边的元素当做分界值
            Comparable key = a[0];
            //定义两个指针，分别指向待切分元素的最小索引处和最大所引出的下一个位置
            int left=lo;
            int right=hi+1;

            //切分
            while (true){
                //先从右往左移动，移动right指针，找到一个比分界值小的元素，停止
                while (less(key,a[--right])){//条件为true时就表示，找到了一个比分界值key小的元素a[--right]。而此处的--只表示指针左移。
                    //内部也应该有一个判断
                    if(right==lo){
                        break;//如果右指针right移动到最左边仍然没有找到比分界值key小的元素，那么就不要再继续向左移动了，结束扫描
                    }
                }

                //再从左往右移动，移动left指针，找到一个比分界值大的元素，停止
                while (less(a[++left],key)){
                    if(left==hi){
                        break;
                    }

                }

                //判断left是否>=right，若是，则说明数组中的全部元素已经扫描完毕，结束循环；否则，交换元素即可。
                if(left>=right){
                    break;
                }else {
                    exch(a,left,right);
                }
            }
            //交换分界值，此处必须使用right，因为外部while循环结束时，可能出现left比right大的情况
            exch(a,lo,right);
            //返回分界值所在的索引，此处必须使用right，因为外部while循环结束时，可能出现left比right大的情况
            return right;
        }
    }
}
