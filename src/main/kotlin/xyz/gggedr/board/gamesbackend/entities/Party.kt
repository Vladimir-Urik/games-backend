package xyz.gggedr.board.gamesbackend.entities

import xyz.gggedr.board.gamesbackend.enums.Game
import java.util.concurrent.TimeUnit
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(schema="parties", name = "parties")
data class Party(
    @Id
    @GeneratedValue
    val id: Long? = 0,

    val name: String,
    val code: String,
    val gameType: Game,

    val creationDate: Long = System.currentTimeMillis(),
    val expirationDate: Long = (creationDate + TimeUnit.MINUTES.toMillis(30)),
    val closed: Boolean = false,
    val closedReason: String? = null
)
