package player

import main.GamePanel
import java.awt.image.BufferedImage

class Player(private var gamePanel: GamePanel) {

    private lateinit var drawPlayer: BufferedImage

    private var playerX: Int = 0

    private var playerY: Int = 0

    init {

        this.gamePanel = gamePanel
    }

    fun getDrawPlayer(): BufferedImage {

        return drawPlayer
    }

    fun setDrawPlayer(drawPlayer: BufferedImage) {

        this.drawPlayer = drawPlayer
    }

    fun getPlayerX(): Int {

        return playerX
    }

    fun setPlayerX(playerX: Int) {

        this.playerX = playerX
    }

    fun getPlayerY(): Int {

        return playerY
    }

    fun setPlayerY(playerY: Int) {

        this.playerY = playerY
    }
}