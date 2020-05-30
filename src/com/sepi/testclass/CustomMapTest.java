package com.sepi.testclass;

/**
 * @author Ananth-SePi
 * Test class to perform the available operations on the custom hash map.
 */

import java.util.Scanner;

import com.sepi.custommap.CustomHashMap;

public class CustomMapTest {
	
	public static void main(String[] args) {
		Boolean isException = false;
		Scanner scanner = new Scanner(System.in);
		System.out.print("Please enter the required map size: ");
		Integer mapSize = scanner.nextInt();
		CustomHashMap<String, String> customHashMap = new CustomHashMap<String, String>(mapSize);
		for (Integer var = 0; var < mapSize; var++) {
			System.out.print("\nKey: ");
			String key = scanner.next();
			System.out.print("\nValue: ");
			String value = scanner.next();
			try {
				customHashMap.put(key, value);
			} catch (Exception e) {
				e.printStackTrace();
				isException = true;
				break;
			}
		}
		if (!isException) {
			System.out.println("Map: " + customHashMap.print());
			System.out.print("\nDo you want to delete any item in the map? (Y/N)");
			if (scanner.next().equalsIgnoreCase("Y")) {
				System.out.print("\nEnter the key to delete: ");
				try {
					customHashMap.remove(scanner.next());
					System.out.println("Map: " + customHashMap.print());
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		scanner.close();
	}

}
