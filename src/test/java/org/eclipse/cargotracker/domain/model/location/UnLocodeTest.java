package org.eclipse.cargotracker.domain.model.location;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class UnLocodeTest {

  @Test
  public void testValidUppercaseAndToString() {
    UnLocode ul = new UnLocode("usnyc");
    assertEquals("USNYC", ul.getIdString());
    assertEquals("USNYC", ul.toString());
  }

  @Test
  public void testEqualsAndHashCode() {
    UnLocode a = new UnLocode("usnyc");
    UnLocode b = new UnLocode("USNYC");
    UnLocode c = new UnLocode("NLAMS");

    assertEquals(a, b);
    assertEquals(a.hashCode(), b.hashCode());
    assertTrue(a.sameValueAs(b));

    assertNotEquals(a, c);
    assertFalse(a.sameValueAs(c));
  }

  @Test
  public void testInvalidPatternThrows() {
    assertThrows(IllegalArgumentException.class, () -> new UnLocode("ABC"));
  }

  @Test
  public void testNullThrows() {
    assertThrows(NullPointerException.class, () -> new UnLocode(null));
  }
}
