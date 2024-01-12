package main

import player.Player
import java.awt.Color
import java.awt.Dimension
import java.awt.Font
import java.awt.Graphics
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

    init {

        this.preferredSize = Dimension(screenWidth, screenHeight)

        setBackground(Color.BLACK)

        val jl = JLabel("RPG")

        jl.setFont(Font(Font.MONOSPACED, Font.BOLD, 20))

        jl.setForeground(Color.WHITE)

        add(jl)

        player.getPlayerImage()
    }

    override fun processKeyEvent(e: KeyEvent) {

        if (e.id == KeyEvent.KEY_PRESSED) {

            wmKeyDown(e.keyCode)
        }
    }

    fun wmKeyDown(code: Int) {

        println("キー" + code + "が,押されました！")

        player.move(code)

        repaint()
    }

    override fun paintComponent(g: Graphics) {

        super.paintComponent(g)

        requestFocusInWindow()

        g.color = Color.ORANGE

        g.fillRect(100, 100, 500, 300)

        player.draw(g)
    }
}
