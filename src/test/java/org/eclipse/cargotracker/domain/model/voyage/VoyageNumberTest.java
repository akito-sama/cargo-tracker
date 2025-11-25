package org.eclipse.cargotracker.domain.model.voyage;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class VoyageNumberTest {

  @Test
  public void testEqualsHashCodeGetIdString() {
    VoyageNumber a = new VoyageNumber("V001");
    VoyageNumber b = new VoyageNumber("V001");
    VoyageNumber c = new VoyageNumber("V999");

    assertEquals(a, b);
    assertEquals(a.hashCode(), b.hashCode());
    assertEquals("V001", a.getIdString());

    assertNotEquals(a, c);
  }

  @Test
  public void testNullConstructorThrows() {
    assertThrows(NullPointerException.class, () -> new VoyageNumber(null));
  }
}
