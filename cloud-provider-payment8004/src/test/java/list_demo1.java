import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;

public class list_demo1 {

    @Test
    public void list01(){

        // 1. 创建 list
        final ArrayList<String> list = new ArrayList<String>();
//        final LinkedList<String> list = new LinkedList<String>();

        // 2. 向list中添加数据
        for (int i = 0; i < 5; i++) {
            list.add("第" + i + " 元素");
        }
        // 3.1 通过下标进行遍历输出
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }

        // 3.2 使用增强for循环进行遍历输出   （朕常用的）
        for (String s : list) {
            System.out.println(s);   // s 表示list中的某一个元素  底层采用迭代器实现
        }

        // 3.3 如果只是单纯的遍历 可以这么写，省事。 它是java8的新特性  采用了语法糖的形式，是3.2的简化版
        list.forEach(System.out::println);
    }
}
