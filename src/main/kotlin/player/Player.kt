package player

import main.GamePanel
import java.awt.event.KeyEvent
import java.awt.image.BufferedImage
import java.io.IOException
import javax.imageio.ImageIO

class Player(private var gamePanel: GamePanel) {

    private lateinit var drawPlayer: BufferedImage

    private var playerX: Int = 0

    private var playerY: Int = 0

    init {

        this.gamePanel = gamePanel
    }

    fun getPlayerImage() {

        try {

            setDrawPlayer(
                ImageIO.read(
                    javaClass.getClassLoader()
                        .getResourceAsStream("images/player.png")
                )
            )

            setDrawPlayer(getDrawPlayer().getSubimage(0, 0, 32, 32))

        } catch (e: IOException) {

            e.printStackTrace()
        }
    }

    fun move(kc: Int) {

        if (kc == KeyEvent.VK_D) {

            setPlayerX(getPlayerX() + 32)
        }

        if (kc == KeyEvent.VK_A) {

            setPlayerX(getPlayerX() - 32)
        }

        if (kc == KeyEvent.VK_W) {

            setPlayerY(getPlayerY() - 32)
        }

        if (kc == KeyEvent.VK_S) {

            setPlayerY(getPlayerY() + 32)
        }
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