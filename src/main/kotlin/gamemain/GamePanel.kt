package main

import player.Player
import tile.Tile
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

    /**
     * Col 列　Row　行
     */

    private val maxWorldMapCol = 50

    private val maxWorldMapRow = 50

    private val screenWidth = tileSize * maxScreenRow

    private val screenHeight: Int = tileSize * maxScreenCol

    private val player = Player(this)

    private val tile = Tile(this)

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

        /**
         * デバッグ
         */

        val drawStart = 0
        if (player.checkDrawTime) {

            var drawStart: Long = System.nanoTime()
            if (player.showDebugText) {
                drawStart = System.nanoTime()
            }

        }

        g.color = Color.ORANGE

        g.fillRect(100, 100, 500, 300)

        tile.draw(g)

        player.draw(g)

        if (player.showDebugText) {

            val drawEnd: Long = System.nanoTime()

            val passed: Long = drawEnd - drawStart

            g.font = Font("アリアル", Font.PLAIN, 20)

            g.color = Color.WHITE

            val x = 10

            var y = 400

            val lineHeight = 20

            g.drawString("WorldX" + player.getPlayerX(), x, y)

            y += lineHeight

            g.drawString("WorldY" + player.getPlayerY(), x, y)

            y += lineHeight

            g.drawString(
                "Col" + (player.getPlayerX() / getTileSize()), x, y
            )

            y += lineHeight

            g.drawString(
                "Row" + (player.getPlayerY() / getTileSize()), x, y
            )

            y += lineHeight

            g.drawString("Draw Time: $passed", x, y)

            println("Draw Time: " + passed / 1000000000)

            /**
             * dispose
             *
             * リソースを節約するため
             */

            g.dispose()

        }
    }

    fun getTileSize(): Int {

        return tileSize - originalTileSize
    }

    fun getPlayer(): Player {

        return player
    }

    fun getMaxScreenRow(): Int {

        return maxScreenRow
    }

    fun getMaxScreenCol(): Int {

        return maxScreenCol
    }

    fun getMaxWorldMapCol(): Int {

        return maxWorldMapCol
    }

    fun getMaxWorldMapRow(): Int {

        return maxWorldMapRow
    }
}
