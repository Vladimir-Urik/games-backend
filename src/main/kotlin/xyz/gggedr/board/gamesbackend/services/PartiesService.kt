package xyz.gggedr.board.gamesbackend.services

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
        val creationDate = System.currentTimeMillis();
        val expirationDate = creationDate + TimeUnit.MINUTES.toMillis(30)

        val party = Party(
            id = 0,
            name = "$nickName's party #${generateRandomString(4)}",
            code = generatePartyCode(gameType),
            gameType = gameType,
            creationDate = creationDate,
            expirationDate = expirationDate
        )

        val savedParty = partyRepository.save(party);

        return savedParty;
    }

    private fun generatePartyCode(gameType: Game): String {
        var code = generateRandomString(8)
        while (partyRepository.findPartyByCodeAndGameType(code, gameType) != null) {
            code = generateRandomString(8)
        }

        return code
    }

}