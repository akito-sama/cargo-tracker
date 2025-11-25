package org.eclipse.cargotracker.domain.model.cargo;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class StatusEnumsTest {

  @Test
  public void testRoutingStatusValues() {
    assertEquals(RoutingStatus.ROUTED, RoutingStatus.ROUTED);
    assertNotEquals(RoutingStatus.ROUTED, RoutingStatus.MISROUTED);
  }

  @Test
  public void testTransportStatusValues() {
    assertEquals(TransportStatus.ONBOARD_CARRIER, TransportStatus.ONBOARD_CARRIER);
    assertNotEquals(TransportStatus.CLAIMED, TransportStatus.UNKNOWN);
  }
}
