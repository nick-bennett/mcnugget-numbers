package edu.cnm.deepdive;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Incorporates a number of {@code static} methods related to the Coin problem and Frobenius
 * numbers. Currently, the implementation focus is on <em>McNugget numbers</em> and variations on
 * that concept, using those problems as a context for exploring practical applications (and
 * pitfalls) of recursion.
 *
 * @author Nicholas Bennett &amp; Deep Dive Coding Java Bootcamp Cohort 9.
 */
public class Frobenius {

  private Frobenius() {}

  /**
   * Determines if {@code value} can be expressed as the sum of non-negative integral multiples of
   * 6, 9, and 20 (the original McNuggets pack sizes).
   *
   * @param value target/goal number.
   * @return {@code true} if {@code value} is a McNugget number using the original pack sizes (6, 9,
   * and 20), {@code false} otherwise.
   */
  public static boolean isMcNugget(int value) {
    return isGeneralMcNugget(value, new int[]{20, 9, 6});
  }

  /**
   * Determines if {@code value} can be expressed as the sum of non-negative integral multiples of
   * the elements of {@code packSizes}. As the name implies, this method is the generalized version
   * of {@link #isMcNugget(int)}: If we invoke {@code
   * isGeneralMcNugget(value, new int[]{20, 9, 6})}, the result returned will be identical to that
   * returned by {@link #isMcNugget(int) isMcNugget(value)}.)
   *
   * @param value target/goal number.
   * @param packSizes array of distinct, positive {@code int }pack sizes, in descending order.
   * @return {@code true} if {@code value} is a McNugget number using the specific pack sizes,
   *         {@code false} otherwise.
   */
  public static boolean isGeneralMcNugget(int value, int[] packSizes) {
    return isGeneralMcNugget(value, packSizes, new HashMap<>());
  }

  private static boolean isGeneralMcNugget(int value, int[] packSizes, Map<Integer, Boolean> map) {
    boolean result = false;
    if (value == 0) {
      result = true;
    } else if (value > 0) {
      if (!map.containsKey(value)) {
        for (int i = 0; i < packSizes.length; i++) {
          if (isGeneralMcNugget(value - packSizes[i],
              Arrays.copyOfRange(packSizes, i, packSizes.length), map)) {
            result = true;
            break;
          }
        }
        map.put(value, result);
      } else {
        result = map.get(value);
      }
    }
    return result;
  }

}
