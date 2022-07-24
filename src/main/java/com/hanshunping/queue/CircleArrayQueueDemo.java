package com.hanshunping.queue;

import lombok.Data;

import java.util.Scanner;

/**
 * @ClassName CircleArrayQueueDemo
 * @Description TODO
 * @Author LuKun
 * @Date 2022/7/6 21:41
 * @Version 1.0
 */
public class CircleArrayQueueDemo {
    public static void main(String[] args) {
        CircleArray arrayQueue = new CircleArray(4);//说明设置4，其队列的有效数据最大是3
        char key=' ';//接收用户输入
        Scanner scanner = new Scanner(System.in);
        boolean loop=true;
        while (loop){
            System.out.println("s(show):显示队列");
            System.out.println("e(exit):退出程序");
            System.out.println("a(add):添加数据到队列");
            System.out.println("g(get):从队列取出数据");
            System.out.println("h(head):查看队列头的数据");
            key=scanner.next().charAt(0);
            switch (key){
                case 's':
                    arrayQueue.showQueue();
                    break;
                case 'e':
                    scanner.close();
                    loop=false;
                    break;
                case 'a':
                    System.out.println("请输入一个数: ");
                    int value= scanner.nextInt();
                    arrayQueue.addQueue(value);
                    break;
                case 'g':
                    try {
                        int res = arrayQueue.getQueue();
                        System.out.printf("取出的数据是%d\n",res);
                    }catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'h':
                    try {
                        int res = arrayQueue.headQueue();
                        System.out.printf("队列头的数据是%d\n",res);
                    }catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;
                default:break;
            }
        }
        System.out.println("程序退出!");
    }
}
@Data
class CircleArray{
    private int maxSize;//表示数组的最大容量
    //front 变量的含义做一个调整：front 就指向队列的第一个元素，也就是说arr[front]
    //front 的初始值为0
    private int front;
    //rear 变量的含义做一个调整:rear指向队列的最后一个元素的后一个位置。因为希望空出一个空间
    //rear 的初始值为0
    private int rear;
    private int[] arr;//该数据用于存放数组，模拟队列

    public CircleArray(int arrMaxSize){
        maxSize=arrMaxSize;
        arr=new int[maxSize];
    }

    public boolean isFull(){
        return (rear+1)%maxSize==front;
    }

    public boolean isEmpty(){
        return rear==front;
    }

    //添加数据到队列
    public void addQueue(int n){
        if (isFull()){
            System.out.println("队列满，不能加入数据");
            return;
        }
        arr[rear]=n;
        rear=(rear+1)%maxSize;
    }

    public int getQueue() {
        if(isEmpty())throw new RuntimeException("队列为空,获取数据失败!");

        //这里需要分析出front是指向队列的第一个元素
        // 1.先把front对应的值保留到一个临时变量
        // 2.将front后移,考虑取模
        // 3.将临时保存的变量返回
        int value =arr[front];
        front=(front+1)%maxSize;
        return arr[front];
    }
    //求出当前队列有效数据的个数
    public int size(){
        return (rear+maxSize-front)%maxSize;
    }
    public void showQueue(){
        if(isEmpty()){
            System.out.println("队列为空!");
            return;
        }
        for (int i = front; i < front + size(); i++) {
            System.out.printf("arr[%d]=%d\n",i%maxSize,arr[i%maxSize]);
        }
    }

    //显示队列头数据，注意不是取出数据
    public int headQueue(){
        if(isEmpty()){
            throw new RuntimeException("队列为空");
        }
        return arr[front];
    }

}
