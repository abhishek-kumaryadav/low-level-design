package org.abhk943.repositories;

import java.util.List;
import java.util.Map;

public class FloorRepository {
    private List<Long> floorIds;

    public void save(List<Long> floorIds){
        this.floorIds = floorIds;
    }

    public void add(Long floorId){
        this.floorIds.add(floorId);
    }

    public List<Long> getFloorIds(){
        return this.floorIds;
    }

    public void remove(Long floorId) {
        this.floorIds.remove(floorId);
    }
}
