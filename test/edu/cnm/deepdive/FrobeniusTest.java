package edu.cnm.deepdive;

import static org.junit.jupiter.api.Assertions.*;

import java.util.function.Predicate;
import java.util.regex.Pattern;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

/**
 * Unit tests for the methods of the {@link Frobenius class}.
 */
class FrobeniusTest {

  private static final Pattern SPLIT_PATTERN = Pattern.compile("\\s*,\\s*");

  @DisplayName("Use original McNugget pack sizes (6, 9, 20)")
  @ParameterizedTest(name = "[{index}] value = {0}; expected result = {1}")
  @CsvFileSource(resources = "mcnugget-data.csv", numLinesToSkip = 1)
  void isMcNugget(int value, boolean expected) {
    assertEquals(expected, Frobenius.isMcNugget(value));
  }

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