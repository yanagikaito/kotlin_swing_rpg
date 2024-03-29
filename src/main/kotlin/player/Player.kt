package player

import main.GamePanel
import java.awt.Graphics
import java.awt.event.KeyEvent
import java.awt.image.BufferedImage
import java.io.IOException
import javax.imageio.ImageIO

class Player(private var gamePanel: GamePanel) {

    private lateinit var drawPlayer: BufferedImage

    private var playerX: Int = 0

    private var playerY: Int = 0

    var checkDrawTime = false

    var showDebugText = false

    init {

        this.gamePanel = gamePanel
    }

    fun getPlayerImage() {

        try {

            setDrawPlayer(
                ImageIO.read(
                    javaClass.getClassLoader()
                        .getResourceAsStream("images/frame_01.png")
                )
            )

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

        /**
         * デバッグ
         */

        if (kc == KeyEvent.VK_T) {

            if (!showDebugText) {

                showDebugText = true

            } else if (showDebugText) {

                showDebugText = false

            }
        }
    }

    fun draw(g: Graphics) {

        g.drawImage(getDrawPlayer(), getPlayerX(), getPlayerY(), null)
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
