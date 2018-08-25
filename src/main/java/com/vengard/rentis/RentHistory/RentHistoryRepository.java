package com.vengard.rentis.RentHistory;

import com.vengard.rentis.RentHistory.RentHistory;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RentHistoryRepository extends CrudRepository<RentHistory, Long>{

    RentHistory save(RentHistory rentHistory);

}
