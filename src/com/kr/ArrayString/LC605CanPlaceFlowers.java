package com.kr.ArrayString;

public class LC605CanPlaceFlowers {

	public static void main(String[] args) {
		SolutionLC605 solution = new SolutionLC605();

		int[] array1 = { 1, 0, 0, 0, 1 };
		System.out.println(solution.canPlaceFlowers(array1, 1));

		int[] array2 = { 1, 0, 0, 0, 1 };
		System.out.println(solution.canPlaceFlowers(array2, 2));

		int[] array3 = { 0, 0, 1, 0, 0 };
		System.out.println(solution.canPlaceFlowers(array3, 2));

	}

}

class SolutionLC605 {
	public boolean canPlaceFlowers(int[] flowerbed, int n) {

		for (int i = 0; (i < flowerbed.length && n > 0); i++) {

			if ((flowerbed[i] == 0) && (i == 0 || flowerbed[i - 1] == 0)
					&& (i == flowerbed.length - 1 || flowerbed[i + 1] == 0)) {
				flowerbed[i++] = 1;
				n--;
			}

		}
		return n <= 0;
	}
}
