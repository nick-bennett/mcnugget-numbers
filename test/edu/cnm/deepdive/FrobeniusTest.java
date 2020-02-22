package edu.cnm.deepdive;

import static org.junit.jupiter.api.Assertions.*;

import java.util.function.Predicate;
import java.util.regex.Pattern;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

/**
 * Unit tests for the methods of the {@link Frobenius} class.
 */
class FrobeniusTest {

  /** Comma (with optional whitespace) separator between pack sizes. */
  static final String SPLIT_REGEX = "\\s*,\\s*";
  /** Compiled version of {@link #SPLIT_REGEX}. */
  static final Pattern SPLIT_PATTERN = Pattern.compile("\\s*,\\s*");

  private FrobeniusTest() {}

  /**
   * Tests {@link Frobenius#isMcNugget(int)} with {@code value}, comparing the result to {@code
   * expected}. These values are currently taken from {@code edu/cnm/deepdive/mcnugget-data.csv}.
   *
   * @param value target/goal.
   * @param expected known McNugget number status of {@code value}.
   */
  @DisplayName("Use original McNugget pack sizes (6, 9, 20)")
  @ParameterizedTest(name = "[{index}] value = {0}; expected result = {1}")
  @CsvFileSource(resources = "mcnugget-data.csv", numLinesToSkip = 1)
  void isMcNugget(int value, boolean expected) {
    assertEquals(expected, Frobenius.isMcNugget(value));
  }

  /**
   * Tests {@link Frobenius#isGeneralMcNugget(int, int[])} with {@code value} and {@code packString}
   * (the latter read from the CSV file source as a {@code String}, then split into an {@code
   * int[]}), comparing the result to {@code expected}. These values are currently taken from {@code
   * edu/cnm/deepdive/general-mcnugget-data.csv}.
   *
   * @param value target/goal.
   * @param packString comma-delimited {@code String} of pack sizes.
   * @param expected known generalized McNugget number status of {@code value}, for pack sizes
   *                 specified in {@code packString}.
   */
  @DisplayName("Use pack sizes specified in test cases")
  @ParameterizedTest(name = "[{index}] value = {0}, pack sizes = [{1}]; expected result = {2}")
  @CsvFileSource(resources = "general-mcnugget-data.csv", numLinesToSkip = 1)
  void isGeneralMcNugget(int value, String packString, boolean expected) {
    int[] packSizes = SPLIT_PATTERN.splitAsStream(packString)
        .filter(Predicate.not(String::isEmpty))
        .mapToInt(Integer::parseInt)
        .toArray();
    assertEquals(expected, Frobenius.isGeneralMcNugget(value, packSizes));
  }

}