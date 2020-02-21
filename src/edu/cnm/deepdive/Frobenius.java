package edu.cnm.deepdive;

/**
 * Incorporates a number of {@code static} methods related to the Coin problem and Frobenius
 * numbers. Currently, the implementation focus is on <em>McNugget numbers</em> and variations on
 * that concept, using those problems as a context for exploring practical applications (and
 * pitfalls) of recursion.
 *
 * @author Nicholas Bennett &amp; Deep Dive Coding Java Bootcamp Cohort 9.
 */
public class Frobenius {

  /**
   * Determines if {@code value} can be expressed as the sum of non-negative integral multiples of
   * 6, 9, and 20 (the original McNuggets pack sizes).
   *
   * @param value target/goal number.
   * @return {@code true} if {@code value} is a McNugget number using the original pack sizes (6, 9,
   * and 20), {@code false} otherwise.
   */
  public static boolean isMcNugget(int value) {
    /*
         TODO When the isGeneralMcNugget implementation is complete, modify this method to invoke the
          general method, e.g.

              return isGeneralMcNugget(value, new int[]{20, 9, 6};
    */
    return
        value >= 0
        && (
            value == 0
            || isMcNugget(value - 20)
            || isMcNugget(value - 9)
            || isMcNugget(value - 6)
        );
  }

  /**
   * Determines if {@code value} can be expressed as the sum of non-negative integral multiples of
   * the elements of {@code packSizes}. (If we invoke {@code
   * isGeneralMcNugget(value, new int[]{20, 9, 6})}, the result returned should be identical to that
   * returned by {@link #isMcNugget(int) isMcNugget(value)}.
   *
   * @param value target/goal number.
   * @param packSizes array of distinct, positive {@code int }pack sizes, in descending order.
   * @return {@code true} if {@code value} is a McNugget number using the specific pack sizes,
   * {@code false} otherwise.
   */
  public static boolean isGeneralMcNugget(int value, int[] packSizes) {
    return false; // TODO Complete implementation for extra credit.
  }

}
