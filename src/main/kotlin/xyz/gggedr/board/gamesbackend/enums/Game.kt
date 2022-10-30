package xyz.gggedr.board.gamesbackend.enums

import xyz.gggedr.board.gamesbackend.models.GameModel

enum class Game(
    val displayName: String,
    val description: String,
    val icon: String,
) {

    SHIPS("Ships", "Play the classic game of ships", "ships"),
    CARDS("Cards", "Play the classic game of cards", "cards");

    fun transferToModel(): GameModel {
        return GameModel(
            this.displayName,
            this.description,
            this.icon,
            this.name
        )
    }
}