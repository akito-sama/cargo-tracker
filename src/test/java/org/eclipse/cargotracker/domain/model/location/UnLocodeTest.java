package org.eclipse.cargotracker.domain.model.location;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class UnLocodeTest {

  @Test
  void testValidUppercaseAndToString() {
    UnLocode ul = new UnLocode("usnyc");
    assertEquals("USNYC", ul.getIdString());
    assertEquals("USNYC", ul.toString());
  }

  @Test
  void testEqualsAndHashCode() {
    UnLocode a = new UnLocode("usnyc");
    UnLocode b = new UnLocode("USNYC");
    UnLocode c = new UnLocode("NLAMS");

    assertEquals(a, b);
    assertEquals(a.hashCode(), b.hashCode());

    assertNotEquals(a, c);
  }

  @Test
  void testInvalidPatternThrows() {
    assertThrows(IllegalArgumentException.class, () -> new UnLocode("ABC"));
  }

  @Test
  void testNullThrows() {
    assertThrows(NullPointerException.class, () -> new UnLocode(null));
  }
}
