package com.vengard.rentis.RentHistory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RentHistoryService {

    @Autowired
    private RentHistoryRepository rentHistoryRepository;

    public RentHistory addRentHistory(RentHistory rentHistory) {
        return rentHistoryRepository.save(rentHistory);
    }

}
