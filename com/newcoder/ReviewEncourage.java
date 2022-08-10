package com.newcoder;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @description: 美团 后台方向 2020校招在线考试
 * 评价运营活动激励发放 多线程
 * @author: sixiermu
 * @time: 2022/8/8 10:10
 */
public class ReviewEncourage {
    private   int times;
    private  volatile int state = 1;
    private Lock lock = new ReentrantLock();

    AtomicInteger index = new AtomicInteger(1);

    public ReviewEncourage(int n) {
        this.times  = n;// 构造函数,n为中奖用户数
    }

/*

    PrizePool类仅有一个send方法，实现如下：

    public class PrizePool {

        public void send(String input) {

            System.out.print(input);

        }

    }

  */

    public void bonus(String s) {
        while(true){
            synchronized (lock){
                lock.notifyAll();
               // System.out.println("Thread_get_lock:"+ Thread.currentThread().getName()+ "--state:"+state);
                if(state<=times){
                    if(state%2==1){
                        System.out.println("Thread:"+ Thread.currentThread().getName() + "--out:" +s);
                        state++;
                    }
                }else {
                    break;
            }
                try {
                    //暂停线程并释放锁
                    lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }  // 仅能打印A，表示发放积分

    public void coupon(String s) {
        while (true){
            synchronized (lock) {
                lock.notifyAll();
               // System.out.println("Thread_get_lock:"+ Thread.currentThread().getName()+ "--state:"+state);
                if (state <= times) {
                    if (state % 4 != 0 && state % 2 == 0) {
                        System.out.println("Thread:"+ Thread.currentThread().getName() + "--out:" +s);
                        state++;
                    }
                } else {
                    break;
                }
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }
    }  // 仅能打印B，表示发放优惠券

    public void contribution(String s) {
        while (true){
            synchronized (lock) {
                lock.notifyAll();
              //  System.out.println("Thread_get_lock:"+ Thread.currentThread().getName()+ "--state:"+state);
                if (state <= times) {
                    if (state % 4 == 0) {
                        System.out.println("Thread:"+ Thread.currentThread().getName() + "--out:" +s);
                        state++;
                    }
                }else {
                    break;
                }
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }  // 仅能打印C，表示发放贡献值

    public static void main(String[] args) {
        ReviewEncourage re = new ReviewEncourage(10);
        Thread a = new Thread(new Runnable() {
            @Override
            public void run() {
                re.bonus("A");
            }
        },"A");

        Thread b=new Thread(new Runnable() {
            @Override
            public void run() {
                re.coupon("B");
            }
        },"B");

        Thread c = new Thread(new Runnable() {
            @Override
            public void run() {
                re.contribution("C");
            }
        },"C");

        a.start();
        b.start();
        c.start();
    }
}