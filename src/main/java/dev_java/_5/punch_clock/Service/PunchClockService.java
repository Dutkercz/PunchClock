package dev_java._5.punch_clock.Service;

import dev_java._5.punch_clock.Repositories.PunchClockRespository;
import dev_java._5.punch_clock.entities.PunchClock;
import dev_java._5.punch_clock.entities.PunchClockDTO;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PunchClockService {

    @Autowired
    private PunchClockRespository respository;

    @Transactional
    public PunchClock saveRegister(PunchClockDTO data) {
        return respository.save(
                new PunchClock(null, data.type(), data.timeStamp(), data.user()));
    }
}
