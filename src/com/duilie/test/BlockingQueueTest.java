package com.duilie.test;

import java.util.Map;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;

/**
 * 阻塞队列的api使用
 * @author chenzhaoping
 *
 */
public class BlockingQueueTest {
	public static void main(String[] args) {
		
		Map<String, String> map = new ConcurrentHashMap<>();
		BlockingQueue<String> queue = new ArrayBlockingQueue<>(3);//初始化值为3
		//add方法返回Boolean值类型,添加成功返回true
		System.out.println(queue.add("a"));
		System.out.println(queue.add("b"));
		System.out.println(queue.add("c"));
		//System.out.println(queue.add("d"));//超过队列长度时会抛出Queue full(队列已满)
		
		//element方法判断该队列是否有值,如果又返回第一个
		//System.out.println(queue.element());
		
		//remove方法返回的是被移除的对象
		System.out.println(queue.remove());//移除第一个进来的
		System.out.println(queue.remove());
		System.out.println(queue.remove());
		//System.out.println(queue.remove()); //队列里没有之值后会抛出java.util.NoSuchElementException(没有值了)
		//System.out.println(queue.remove("b"));//移除制订对象
		//System.out.println(queue.toString());
		
		System.out.println("---------------------------------------");
		
		
		BlockingQueue<String> test = new ArrayBlockingQueue<>(3);//初始化值为3
		//offer方法返回布尔类型,添加成功返回true
		System.out.println(test.offer("e"));
		System.out.println(test.offer("f"));
		System.out.println(test.offer("g"));
		//System.out.println(test.offer("h"));//超过队列长度时会返回布尔类型false
		
		//peek方法判断该队列是否又值,如果有返回第一个
		//System.out.println(test.peek());
		
		//poll方法返回的是被移除的对象
		System.out.println(test.poll());//移除第一个进来的
		System.out.println(test.poll());
		System.out.println(test.poll());
		System.out.println(test.poll());//队列里没有之值后会返回null
		
		System.out.println("++++++++++++++++++++++++++++++++++++++++++++++");
		
		BlockingQueue<String> blockingQueue = new ArrayBlockingQueue<>(3);//初始化值为3
		try {
			System.out.println(blockingQueue.offer("1", 5,TimeUnit.SECONDS));
			System.out.println(blockingQueue.offer("2", 5,TimeUnit.SECONDS));
			System.out.println(blockingQueue.offer("3", 5,TimeUnit.SECONDS));
			System.out.println(blockingQueue.offer("4", 5,TimeUnit.SECONDS));//如果队列满了,则在5秒内试着去添加,如果5秒内没有添加成功则返回false
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			System.out.println(blockingQueue.poll(5, TimeUnit.SECONDS));
			System.out.println(blockingQueue.poll(5, TimeUnit.SECONDS));
			System.out.println(blockingQueue.poll(5, TimeUnit.SECONDS));
			System.out.println(blockingQueue.poll(5, TimeUnit.SECONDS));//如果队列没值了,则在5秒内试着去获取,如果5秒内没有获取则返回null
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
