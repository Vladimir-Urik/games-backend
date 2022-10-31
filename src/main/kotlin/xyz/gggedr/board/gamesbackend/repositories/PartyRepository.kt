package xyz.gggedr.board.gamesbackend.repositories

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import xyz.gggedr.board.gamesbackend.entities.Party
import xyz.gggedr.board.gamesbackend.enums.Game

@Repository
interface PartyRepository : JpaRepository<Party, Long> {

    fun findPartyByCodeAndGameTypeAndClosed(code: String, gameType: Game, closed: Boolean): Party?

    fun findAllByClosedAndExpirationDateBefore(closed: Boolean, expirationDate: Long): List<Party>

}