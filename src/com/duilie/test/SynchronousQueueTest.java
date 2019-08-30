package com.duilie.test;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;

/**
 * 阻塞型队列
 * SynchronousQueue 不存贮消息,存进去一个后不能在存了,只能等消费后在存
 * 
Thread-0 : 往队列里存值  a
Thread-1: a
Thread-0 : 往队列里存值  b
Thread-1: b
Thread-0 : 往队列里存值  c
Thread-1: c
 *
 */
public class SynchronousQueueTest {
	public static void main(String[] args) {
		
		BlockingQueue<String> queue = new SynchronousQueue<>();
		
		//该线程用于存值
		new Thread(()->{
			try {
				System.out.println(Thread.currentThread().getName()+" : 往队列里存值  a");
				queue.put("a");//存a后要等待消费了才会去存b
				
				System.out.println(Thread.currentThread().getName()+" : 往队列里存值  b");
				queue.put("b");
				
				System.out.println(Thread.currentThread().getName()+" : 往队列里存值  c");
				queue.put("c");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}).start();
		
		//该线程用于取值  take方法返回的是取出的对象
		new Thread(()->{
			try {
				TimeUnit.SECONDS.sleep(3);//休眠3秒
				System.out.println(Thread.currentThread().getName()+": "+queue.take());
				TimeUnit.SECONDS.sleep(3);
				System.out.println(Thread.currentThread().getName()+": "+queue.take());
				TimeUnit.SECONDS.sleep(3);
				System.out.println(Thread.currentThread().getName()+": "+queue.take());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}).start();
	}
}
