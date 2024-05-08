package org.abhk943.services.interfaces;

import org.abhk943.models.Location;
import org.abhk943.models.User;

public interface LocationObserver {
    public void notify(User user, Location location);
}
