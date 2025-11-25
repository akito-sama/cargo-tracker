package org.eclipse.cargotracker.domain.model.cargo;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class StatusEnumsTest {

  @Test
  void testRoutingStatusValues() {
    assertNotEquals(RoutingStatus.ROUTED, RoutingStatus.MISROUTED);
  }

  @Test
  void testTransportStatusValues() {
    assertNotEquals(TransportStatus.CLAIMED, TransportStatus.UNKNOWN);
  }
}
