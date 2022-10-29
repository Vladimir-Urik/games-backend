package xyz.gggedr.board.gamesbackend.controllers

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import xyz.gggedr.board.gamesbackend.enums.Games
import xyz.gggedr.board.gamesbackend.models.GameModel

@RestController
@RequestMapping("/games")
class GamesController {

    @GetMapping
    fun getGames(): List<GameModel> {
        return Games.values().map {
            it.transferToModel()
        }
    }

}