package org.eclipse.cargotracker.domain.model.cargo;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class StatusEnumsTest {

  @Test
  public void testRoutingStatusSameValueAs() {
    assertTrue(RoutingStatus.ROUTED.sameValueAs(RoutingStatus.ROUTED));
    assertFalse(RoutingStatus.ROUTED.sameValueAs(RoutingStatus.MISROUTED));
  }

  @Test
  public void testTransportStatusSameValueAs() {
    assertTrue(TransportStatus.ONBOARD_CARRIER.sameValueAs(TransportStatus.ONBOARD_CARRIER));
    assertFalse(TransportStatus.CLAIMED.sameValueAs(TransportStatus.UNKNOWN));
  }
}
