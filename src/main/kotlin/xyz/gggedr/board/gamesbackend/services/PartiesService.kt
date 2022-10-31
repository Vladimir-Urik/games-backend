package xyz.gggedr.board.gamesbackend.services

import org.springframework.context.annotation.Bean
import org.springframework.stereotype.Service
import xyz.gggedr.board.gamesbackend.entities.Party
import xyz.gggedr.board.gamesbackend.enums.Game
import xyz.gggedr.board.gamesbackend.repositories.PartyRepository
import xyz.gggedr.board.gamesbackend.utils.StringUtils.Companion.generateRandomString
import java.util.concurrent.TimeUnit

@Service
class PartiesService(
    private val partyRepository: PartyRepository
) {

    fun createParty(gameType: Game, nickName: String): Party {
        val party = Party(
            name = "$nickName's party #${generateRandomString(4)}",
            code = generatePartyCode(gameType),
            gameType = gameType,
        )

        val savedParty = partyRepository.save(party);
        return savedParty;
    }

    private fun generatePartyCode(gameType: Game): String {
        var code = generateRandomString(8)
        while (partyRepository.findPartyByCodeAndGameTypeAndClosed(code, gameType, true) != null) {
            code = generateRandomString(8)
        }

        return code
    }

}