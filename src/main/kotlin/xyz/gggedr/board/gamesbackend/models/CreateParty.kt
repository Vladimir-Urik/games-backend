package xyz.gggedr.board.gamesbackend.models

import xyz.gggedr.board.gamesbackend.enums.Game
import javax.validation.constraints.Max
import javax.validation.constraints.Min
import javax.validation.constraints.NotBlank

data class CreateParty(
    @NotBlank(message = "Nickname is required")
    @Min(value = 3, message = "Nickname must be at least 3 characters long")
    @Max(value = 16, message = "Nickname must be at most 16 characters long")
    val nickname: String,

    @NotBlank(message = "Game type is required")
    val gameType: Game
)
