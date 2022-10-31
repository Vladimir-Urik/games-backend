package xyz.gggedr.board.gamesbackend.tasks

import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Component
import xyz.gggedr.board.gamesbackend.repositories.PartyRepository
import java.util.concurrent.TimeUnit

@Component
class ClosePartyTask(
    private val partyRepository: PartyRepository
) {

    @Scheduled(fixedRate = (1000*60))
    fun closeParties() {
        val parties = partyRepository.findAllByClosedAndExpirationDateAfter(false, System.currentTimeMillis())
        partyRepository.saveAll(parties.map { it.copy(closed = true) })
    }

}