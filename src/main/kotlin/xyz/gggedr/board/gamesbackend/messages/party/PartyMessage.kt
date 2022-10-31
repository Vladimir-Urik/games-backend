package xyz.gggedr.board.gamesbackend.messages.party

import xyz.gggedr.board.gamesbackend.enums.PartyMessageType

data class PartyMessage(
    val type: PartyMessageType,
    val payload: Any
)
