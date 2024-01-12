package tile

import main.GamePanel
import java.awt.Graphics
import java.awt.image.BufferedImage
import java.io.IOException
import javax.imageio.ImageIO

class Tile(private var gamePanel: GamePanel) {

    private lateinit var drawTile: BufferedImage

    private var tileX: Int = 0

    private var tileY: Int = 0

    init {

        this.gamePanel = gamePanel

        drawTile = getTileImage()

    }


    fun getTileImage(): BufferedImage {

        try {

            setDrawTile(
                ImageIO.read(
                    javaClass.getClassLoader()
                        .getResourceAsStream("tiles/prairie.jpeg")
                )
            )


        } catch (e: IOException) {

            e.printStackTrace()
        }

        return drawTile
    }

    fun draw(g: Graphics) {

        var worldCol = 0
        var worldRow = 0

        while (worldCol < gamePanel.getMaxWorldMapCol() && worldRow < gamePanel.getMaxWorldMapRow()) {

            val worldX: Int = worldCol * gamePanel.getTileSize()
            val worldY: Int = worldRow * gamePanel.getTileSize()

            val screenX: Int = worldX
            val screenY: Int = worldY

            g.drawImage(
                drawTile,
                screenX,
                screenY,
                gamePanel.getTileSize(),
                gamePanel.getTileSize(),
                null
            )
            worldCol++

            if (worldCol == gamePanel.getMaxWorldMapCol()) {
                worldCol = 0

                worldRow++

            }
        }
    }


    fun getTileX(): Int {

        return tileX
    }

    fun getDrawTile(): BufferedImage {

        return this.drawTile
    }

    fun getTileY(): Int {

        return tileY
    }

    fun setDrawTile(drawTile: BufferedImage) {

        this.drawTile = drawTile
    }
}
