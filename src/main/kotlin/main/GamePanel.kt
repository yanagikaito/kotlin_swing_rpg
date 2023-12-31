package main

import java.awt.Color
import java.awt.Dimension
import java.awt.Font
import java.awt.Graphics
import java.awt.event.KeyEvent
import java.awt.image.BufferedImage
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

    private lateinit var drawPlayer: BufferedImage

    private var playerX = 0

    private var playerY = 0

    init {

        this.preferredSize = Dimension(screenWidth, screenHeight)

        setBackground(Color.BLACK)

        val jl = JLabel("RPG")

        jl.setFont(Font(Font.MONOSPACED, Font.BOLD, 20))

        jl.setForeground(Color.WHITE)

        add(jl)

        try {

            val file = File("C:\\Users\\meteo\\IdeaProjects\\Swing_rpg\\res\\player.png")

            drawPlayer = ImageIO.read(file)

            drawPlayer = drawPlayer.getSubimage(0, 0, 32, 32)

        } catch (e: IOException) {

            e.printStackTrace()
        }
    }

    override fun paintComponent(g: Graphics) {

        super.paintComponent(g)

        requestFocusInWindow()

        g.color = Color.ORANGE

        g.fillRect(100, 100, 500, 300)

        g.drawImage(drawPlayer, playerX, playerY, null)
    }
}
