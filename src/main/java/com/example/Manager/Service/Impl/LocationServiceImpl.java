package com.example.Manager.Service.Impl;
import com.example.Manager.Dto.LocationDto;
import com.example.Manager.Entity.Location;
import com.example.Manager.Mapper.MapLocation;
import com.example.Manager.Repository.LocationRepository;
import com.example.Manager.Service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LocationServiceImpl implements LocationService {
    @Autowired
    private LocationRepository locationRepository;

    @Autowired
    private MapLocation mapLocation;

    @Override
    public LocationDto createLocation(LocationDto locationDto) {
        Location location = mapLocation.MapLocation(locationDto);
        Location savedLocation = locationRepository.save(location);
        return mapLocation.MapDtoLocation(savedLocation);
    }

    @Override
    public LocationDto updateLocation(Long id, LocationDto locationDto) {
        Location existingLocation = locationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Location not found"));
        existingLocation.setName(locationDto.getName());
        existingLocation.setLocation(locationDto.getLocation());
        existingLocation.setCapacity(locationDto.getCapacity());
        locationRepository.save(existingLocation);
        return mapLocation.MapDtoLocation(existingLocation);
    }

    @Override
    public void deleteLocation(Long id) {
        locationRepository.deleteById(id);
    }

    @Override
    public LocationDto getLocationById(Long id) {
        Location location = locationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Location not found"));
        return mapLocation.MapDtoLocation(location);
    }

    @Override
    public List<LocationDto> getAllLocations() {
        return locationRepository.findAll().stream()
                .map(mapLocation::MapDtoLocation)
                .collect(Collectors.toList());
    }
}
