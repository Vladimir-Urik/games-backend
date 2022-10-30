package xyz.gggedr.board.gamesbackend.entities

import xyz.gggedr.board.gamesbackend.enums.Game
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(schema="parties", name = "parties")
data class Party(
    @Id
    @GeneratedValue
    val id: Long?,

    val name: String,
    val code: String,
    val gameType: Game,

    val creationDate: Long,
    val expirationDate: Long,
)
