package org.eclipse.cargotracker.domain.shared;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class DomainObjectUtilsTest {

  @Test
  public void testNullSafeReturnsActualWhenNotNull() {
    String actual = "value";
    String safe = "safe";
    assertEquals(actual, DomainObjectUtils.nullSafe(actual, safe));
  }

  @Test
  public void testNullSafeReturnsSafeWhenActualNull() {
    String safe = "safe";
    assertEquals(safe, DomainObjectUtils.nullSafe(null, safe));
  }
}
