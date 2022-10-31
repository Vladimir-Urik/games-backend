package xyz.gggedr.board.gamesbackend.tasks

import org.springframework.messaging.simp.SimpMessagingTemplate
import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Component
import xyz.gggedr.board.gamesbackend.enums.PartyMessageType
import xyz.gggedr.board.gamesbackend.messages.party.PartyClosed
import xyz.gggedr.board.gamesbackend.messages.party.PartyMessage
import xyz.gggedr.board.gamesbackend.repositories.PartyRepository

@Component
class ClosePartyTask(
    private val partyRepository: PartyRepository,
    private val simpMessagingTemplate: SimpMessagingTemplate
) {

    @Scheduled(fixedRate = (1000*60))
    fun closeParties() {
        val parties = partyRepository.findAllByClosedAndExpirationDateAfter(false, System.currentTimeMillis())
        partyRepository.saveAll(parties.map { it.copy(closed = true, closedReason = "Party expired") })

        for (party in parties) {
            simpMessagingTemplate.convertAndSend("/game/"+ party.code, PartyMessage(PartyMessageType.CLOSE, PartyClosed(party.code, "Party expired")))
        }
    }

}