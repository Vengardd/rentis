package com.vengard.rentis.service;


import com.vengard.rentis.model.Car;
import com.vengard.rentis.repository.CarRepository;
import com.vengard.rentis.model.RentHistory;
import com.vengard.rentis.repository.RentHistoryRepository;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Optional;

import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class RentHistoryServiceTest {

    @Mock
    private RentHistoryRepository rentHistoryRepository;

    @Mock
    private CarRepository carRepository;

    @InjectMocks
    private RentHistoryService rentHistoryService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void addNewRentHistoryWithCar() {
        Car car = new Car();
        RentHistory rentHistory = new RentHistory();
        rentHistory.setCar(car);

        when(carRepository.findById(anyLong())).thenReturn(Optional.of(car));
        when(rentHistoryRepository.save(any())).thenReturn(rentHistory);

        RentHistory result = rentHistoryService.addRentHistory(rentHistory);

        assertNotNull(result);
        assertNotNull(result.getCar());

        verify(carRepository).save(any());
    }
}
