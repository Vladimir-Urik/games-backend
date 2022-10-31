package xyz.gggedr.board.gamesbackend.messages.party

data class PartyClosed(
    val code: String,
    val reason: String? = "No reason given"
)
