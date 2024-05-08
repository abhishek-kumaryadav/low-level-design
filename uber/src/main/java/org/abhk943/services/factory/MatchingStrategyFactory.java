package org.abhk943.services.factory;

import org.abhk943.exceptions.IllegalActionException;
import org.abhk943.models.enums.MatchingType;
import org.abhk943.services.ShortedDistanceMatchingService;
import org.abhk943.services.interfaces.MatchingStrategy;

public class MatchingStrategyFactory {
    public static MatchingStrategy getStrategy(MatchingType matchingType) throws IllegalActionException {
        switch (matchingType){
            case SHORTEST_DISTANCE:
                return new ShortedDistanceMatchingService();
        }
        throw new IllegalActionException("Illegal matching type provided");
    }

}
