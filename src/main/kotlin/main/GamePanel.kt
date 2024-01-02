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
    }
}
