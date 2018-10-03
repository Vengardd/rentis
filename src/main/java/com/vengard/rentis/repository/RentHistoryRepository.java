package com.vengard.rentis.repository;

import com.vengard.rentis.model.Car;
import com.vengard.rentis.model.RentHistory;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.List;
@Repository
public interface RentHistoryRepository extends CrudRepository<RentHistory, Long> {

    RentHistory save(RentHistory rentHistory);

    @Query(value = "SELECT * FROM RENT_HISTORY WHERE CAR = ?1 AND (DATE_RENT >= ?2 OR PLANNED_DATE_RETURN >= ?2)", nativeQuery = true)
    List<RentHistory> findAllByCarAndDateRentIsAfter(@Param("car") Car car, @Param("date") Timestamp date);

}
