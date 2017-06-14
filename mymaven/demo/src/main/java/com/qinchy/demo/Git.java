/**
 * 
 */
package com.qinchy.demo;

/**
 * @author chaoyong.qin
 *
 */
public class Git {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		for (String string : args) {
			System.out.println(string);
		}
		
		System.out.println("Git.main()");
		
		// 正常退出
		System.exit(0);

		System.out.println("Git.main()");

		if (1 == 1)
			System.out.println(111);

		// 正常退出
		System.exit(0);

	}

}
