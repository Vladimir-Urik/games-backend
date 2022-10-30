package xyz.gggedr.board.gamesbackend.controllers

import org.springframework.web.bind.annotation.*
import xyz.gggedr.board.gamesbackend.entities.Party
import xyz.gggedr.board.gamesbackend.enums.Game
import xyz.gggedr.board.gamesbackend.models.CreateParty
import xyz.gggedr.board.gamesbackend.services.PartiesService

@RestController
@RequestMapping("/parties")
class PartiesController(
    val partiesService: PartiesService
) {

    @PostMapping
    fun createParty(@RequestBody createParty: CreateParty): Party {
        return partiesService.createParty(createParty.gameType, createParty.nickname);
    }

}