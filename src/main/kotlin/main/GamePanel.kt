package main

import player.Player
import java.awt.*
import java.awt.event.KeyEvent
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

    private val keyHandler = KeyHandler(this)

    private val playerHP = 25

    init {

        this.preferredSize = Dimension(screenWidth, screenHeight)

        setBackground(Color.BLACK)

        val jl = JLabel("RPG")

        jl.setFont(Font(Font.MONOSPACED, Font.BOLD, 20))

        jl.setForeground(Color.WHITE)

        add(jl)

        player.getPlayerImage()

        addKeyListener(keyHandler)
    }

    override fun processKeyEvent(e: KeyEvent) {

        player.move(e.keyCode)

        repaint()
    }


    override fun paintComponent(graphics: Graphics) {

        super.paintComponent(graphics)

        requestFocusInWindow()

        val graphics2D = graphics as Graphics2D

        graphics2D.color = Color.ORANGE

        graphics2D.fillRect(100, 100, 500, 300)

        graphics2D.drawImage(player.getDrawPlayer(), player.getPlayerX(), player.getPlayerY(), null)

        graphics2D.color = Color(0, 0, 0, 200)

        graphics2D.fillRoundRect(0, 0, 960, 50, 0, 0)

        // RGBの白色の番号
        graphics2D.color = Color(255, 255, 255)

        graphics2D.setColor(graphics2D.color)

        graphics2D.setStroke(BasicStroke(5f))

        graphics2D.drawRoundRect(x + 5, y + 5, width - 10, height - 10, 25, 25)

        graphics2D.color = Color.WHITE

        graphics2D.font = graphics2D.getFont().deriveFont(Font.PLAIN, 23f)

        graphics2D.drawString("HP$playerHP", 36, 36)
    }
}
