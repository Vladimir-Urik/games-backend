package xyz.gggedr.board.gamesbackend.controllers

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import xyz.gggedr.board.gamesbackend.enums.Game
import xyz.gggedr.board.gamesbackend.models.GameModel

@RestController
@RequestMapping("/games")
class GamesController {

    @GetMapping
    fun getGames(): List<GameModel> {
        return Game.values().map {
            it.transferToModel()
        }
    }

}