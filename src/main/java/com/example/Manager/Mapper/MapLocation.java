package com.example.Manager.Mapper;

import com.example.Manager.Dto.LocationDto;
import com.example.Manager.Entity.Location;

public class MapLocation {
    public static LocationDto MapDtolocation (Location location){
        LocationDto locationDto = new LocationDto();
        locationDto.setId(location.getId());
        locationDto.setName(location.getName());
        locationDto.setLocation(location.getLocation());
        locationDto.setCapacity(location.getCapacity());
        return locationDto;
    }
    public static Location Maplocation (LocationDto locationDto){
        Location location = new Location();
        location.setId(locationDto.getId());
        location.setName(locationDto.getName());
        location.setLocation(locationDto.getLocation());
        location.setCapacity(locationDto.getCapacity());
        return location;
    }
}
