package main

import javax.swing.JPanel

class GamePanel : JPanel() {

    private val originalTileSize = 16

    private val scale = 3

    private val tileSize = originalTileSize * scale

    private val maxScreenRow = 16

    private val maxScreenCol = 12

    val screenWidth = tileSize * maxScreenRow

    val screenHeight: Int = tileSize * maxScreenCol

}