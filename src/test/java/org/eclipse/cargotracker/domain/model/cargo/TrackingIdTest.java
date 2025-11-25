package org.eclipse.cargotracker.domain.model.cargo;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class TrackingIdTest {

  @Test
  public void testEqualsHashCodeAndToString() {
    TrackingId a = new TrackingId("ABC123");
    TrackingId b = new TrackingId("ABC123");
    TrackingId c = new TrackingId("XYZ999");

    assertEquals(a, b);
    assertEquals(a.hashCode(), b.hashCode());
    assertTrue(a.sameValueAs(b));
    assertEquals("ABC123", a.getIdString());
    assertEquals("ABC123", a.toString());

    assertNotEquals(a, c);
    assertFalse(a.sameValueAs(c));
  }

  @Test
  public void testNullConstructorThrows() {
    assertThrows(NullPointerException.class, () -> new TrackingId(null));
  }
}
