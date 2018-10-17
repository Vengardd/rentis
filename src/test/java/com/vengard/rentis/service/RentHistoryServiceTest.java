package com.vengard.rentis.service;


import com.vengard.rentis.exception.CarNotFoundException;
import com.vengard.rentis.model.Car;
import com.vengard.rentis.model.RentHistory;
import com.vengard.rentis.repository.CarRepository;
import com.vengard.rentis.repository.RentHistoryRepository;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Optional;

import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class RentHistoryServiceTest {

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Mock
    private RentHistoryRepository rentHistoryRepository;

    @Mock
    private CarRepository carRepository;

    @Mock
    private CarService carService;

    @InjectMocks
    private RentHistoryService rentHistoryService;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void addNewRentHistoryWithCar() throws CarNotFoundException {
        Car car = new Car();
        RentHistory rentHistory = new RentHistory();
        rentHistory.setCar(car);

        when(rentHistoryRepository.save(any())).thenReturn(rentHistory);
        RentHistory result = rentHistoryService.addRentHistory(rentHistory);

        assertNotNull(result);
        assertNotNull(result.getCar());
    }

    @Test
    public void throwCarNotFoundIn() throws CarNotFoundException {
        thrown.expect(CarNotFoundException.class);
        when(carService.findById(anyLong())).thenThrow(new CarNotFoundException());
        RentHistory rentHistory = rentHistoryService.addRentHistory(new RentHistory());
    }
}
