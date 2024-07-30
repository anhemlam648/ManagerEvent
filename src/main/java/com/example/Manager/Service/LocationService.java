package com.example.Manager.Service;

import com.example.Manager.Dto.LocationDto;

import java.util.List;

public interface LocationService {
    LocationDto createLocation(LocationDto locationDto);
    LocationDto updateLocation(Long id, LocationDto locationDto);
    void deleteLocation(Long id);
    LocationDto getLocationById(Long id);
    List<LocationDto> getAllLocations();
}
