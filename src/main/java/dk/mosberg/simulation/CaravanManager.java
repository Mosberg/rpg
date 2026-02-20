package dk.mosberg.simulation;

import java.util.HashMap;
import java.util.Map;

/**
 * Tracks and manages traveling caravans and trade routes.
 */
public class CaravanManager {
    private final Map<String, String> caravanRoutes = new HashMap<>();

    public void setCaravanRoute(String caravanId, String route) {
        caravanRoutes.put(caravanId, route);
    }

    public String getCaravanRoute(String caravanId) {
        return caravanRoutes.getOrDefault(caravanId, "");
    }

    public Map<String, String> getAllCaravanRoutes() {
        return caravanRoutes;
    }
}
