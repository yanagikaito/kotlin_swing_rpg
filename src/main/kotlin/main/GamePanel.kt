package main

import player.Player
import java.awt.Color
import java.awt.Dimension
import java.awt.Font
import java.awt.Graphics
import java.awt.event.KeyEvent
import java.io.File
import java.io.IOException
import javax.imageio.ImageIO
import javax.swing.JLabel
import javax.swing.JPanel

class GamePanel : JPanel() {

    private val originalTileSize = 16

    private val scale = 3

    private val tileSize = originalTileSize * scale

    private val maxScreenRow = 16

    private val maxScreenCol = 12

    private val screenWidth = tileSize * maxScreenRow

    private val screenHeight: Int = tileSize * maxScreenCol

    private val player = Player(this)

    init {

        this.preferredSize = Dimension(screenWidth, screenHeight)

        setBackground(Color.BLACK)

        val jl = JLabel("RPG")

        jl.setFont(Font(Font.MONOSPACED, Font.BOLD, 20))

        jl.setForeground(Color.WHITE)

        add(jl)

        try {

            val file = File("C:\\Users\\meteo\\IdeaProjects\\Swing_rpg\\res\\player.png")

            player.setDrawPlayer(ImageIO.read(file))

            player.setDrawPlayer(player.getDrawPlayer().getSubimage(0, 0, 32, 32))

        } catch (e: IOException) {

            e.printStackTrace()
        }
    }

    override fun processKeyEvent(e: KeyEvent) {

        if (e.id == KeyEvent.KEY_PRESSED) {

            println("キーが押されました!")

            if (e.keyCode == KeyEvent.VK_D) {

                player.setPlayerX(player.getPlayerX() + 32)

                repaint()
            }
        }
        if (e.keyCode == KeyEvent.VK_A) {

            player.setPlayerX(player.getPlayerX() - 32)

            repaint()
        }
        if (e.keyCode == KeyEvent.VK_W) {

            player.setPlayerY(player.getPlayerY() - 32)

            repaint()
        }
        if (e.keyCode == KeyEvent.VK_S) {

            player.setPlayerY(player.getPlayerY() + 32)

            repaint()
        }
    }

    override fun paintComponent(g: Graphics) {

        super.paintComponent(g)

        requestFocusInWindow()

        g.color = Color.ORANGE

        g.fillRect(100, 100, 500, 300)

        g.drawImage(player.getDrawPlayer(), player.getPlayerX(), player.getPlayerY(), null)
    }
}
