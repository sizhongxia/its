package com.dm.stu;

import java.util.HashSet;
import java.util.Set;

import com.dm.stu.util.PublicUtil;

public class MainTest {

	static class IdWorkThread implements Runnable {
		private Set<String> set;

		public IdWorkThread(Set<String> set) {
			this.set = set;
		}

		@Override
		public void run() {
			while (true) {
				String id = PublicUtil.id();
				if (!set.add(id)) {
					System.out.println(id);
				}
			}
		}
	}

	public static void main(String[] args) {
		Set<String> set = new HashSet<>();
		Thread t1 = new Thread(new IdWorkThread(set));
		Thread t2 = new Thread(new IdWorkThread(set));
		t1.setDaemon(true);
		t2.setDaemon(true);
		t1.start();
		t2.start();
		try {
			Thread.sleep(20000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
