package org.eclipse.cargotracker.domain.shared;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class DomainObjectUtilsTest {

  @Test
  void testNullSafeReturnsActualWhenNotNull() {
    String actual = "value";
    String safe = "safe";
    assertEquals(actual, DomainObjectUtils.nullSafe(actual, safe));
  }

  @Test
  void testNullSafeReturnsSafeWhenActualNull() {
    String safe = "safe";
    assertEquals(safe, DomainObjectUtils.nullSafe(null, safe));
  }
}
