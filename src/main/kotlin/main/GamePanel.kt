import java.awt.Color
import java.awt.Dimension
import java.awt.Graphics
import java.awt.event.KeyAdapter
import java.awt.event.KeyEvent
import java.awt.image.BufferedImage
import java.io.IOException
import java.util.*
import javax.imageio.ImageIO
import javax.swing.JPanel

/**
 * ゲームパネル
 */

class GamePanel : JPanel() {

    private val originalSize = 16

    private val scale = 3

    private val tileSize = scale * originalSize

    private val maxScreenCol = 16

    private val maxScreenRow = 15

    /**
     * 768 ピクセル
     */

    private val screenWidth = tileSize * maxScreenCol

    /**
     * 720 ピクセル
     */

    private val screenHeight = tileSize * maxScreenRow


    /**
     * キー入力を処理するアダプター
     */

    private var keyAdapter: KeyAdapter? = null

    /**
     * キー入力の状態を格納する配列
     */

    private var keyPressTbl: BooleanArray? = null

    /**
     * X座標,Y座標
     */

    private var x = 0

    private var y = 0

    /**
     * 速度
     */

    private var mx = 0

    /**
     * キャラクターの画像
     */

    private var imageShips: Array<BufferedImage?>? = null

    /**
     * キャラクターの向き
     */

    private var playerDirection = 0

    var playerGra: BufferedImage? = null

    var pShift = 0

    /**
     * タイマー
     */

    private var timerThis: Timer? = null

    /**
     * 経過時間
     */

    private var time = 0

    /**
     * ゲームパネルのコンストラクタ
     */

    init {

        try {

            super.setPreferredSize(Dimension(screenWidth, screenHeight))

            super.setLayout(null)

            keyPressTbl = BooleanArray(256)

            imageShips = arrayOfNulls(3)

            // キー押下状態のテーブルの初期化

            keyPressTbl = BooleanArray(256)

            val is0 = this::class.java.getResourceAsStream("images/frame_01.png")

            if (is0 != null) {

                imageShips!![0] = ImageIO.read(is0)

                is0.close()
            }

            val is1 = this::class.java.getResourceAsStream("images/frame_06.png")

            if (is1 != null) {

                imageShips!![1] = ImageIO.read(is1)

                is1.close()
            }

            val is2 = this::class.java.getResourceAsStream("images/frame_03.png")

            if (is2 != null) {

                imageShips!![2] = ImageIO.read(is2)

                is2.close()
            }

            keyAdapter = MGKeyAdapter()

            addKeyListener(keyAdapter)

            timerThis = Timer()

            timerThis!!.scheduleAtFixedRate(TimerActionListener(), 1000L, 8L)

            init()

        } catch (e: IOException) {

            e.printStackTrace()

        }
    }

    /**
     * ゲームの初期化
     */

    fun init() {

        time = 0

        x = 384

        y = 640
    }

    /**
     * ゲームの実行
     */

    fun run() {

        time++

        if (time % 6 == 0) {

            playerDirection = 0

            if (isKeyCodePressed(KeyEvent.VK_A)) {

                playerDirection = 2

                pShift = 4

                mx = mx - 1
            }

            if (isKeyCodePressed(KeyEvent.VK_D)) {

                playerDirection = 1

                pShift = 6

                mx = mx + 1
            }
        }
        if (time % 2 == 0) {

            x = x + mx

            if (x < 0) {

                x = 0

                mx = 0

            } else if (x > width - 32) {

                x = width - 32

                mx = 0
            }

        } else {

            repaint()
        }
    }

    /**
     * 画面描画
     */

    override fun paint(g: Graphics) {

        g.color = Color.black

        g.fillRect(0, 0, 800, 800)

        g.drawImage(imageShips!![playerDirection], x, y, 25, 42, this)

        val sx = 0

        var sy = 0

        val picSize = 32

        if (pShift == 8) sy = 148

        if (pShift == 2) sy = 0

        if (pShift == 4) sy = 48

        if (pShift == 6) sy = 96

        g.drawImage(

            playerGra, x, y - 16, x + picSize, y + picSize, sx,

            sy, sx + picSize, sy + picSize + 16, null
        )
    }

    /**
     * キーコードが押されているかどうかを返す
     */

    fun isKeyCodePressed(keyCode: Int): Boolean {

        return keyPressTbl!![keyCode]
    }

    /**
     * キー入力を処理するアダプタークラス
     */

    private inner class MGKeyAdapter : KeyAdapter() {

        override fun keyPressed(ke: KeyEvent) {

            val code = ke.keyCode

            if (code < 256) {

                keyPressTbl!![code] = true
            }
        }

        override fun keyReleased(ke: KeyEvent) {

            val code = ke.keyCode

            if (code < 256) {

                keyPressTbl!![code] = false
            }
        }
    }

    /**
     * タイマータスククラス
     */

    private inner class TimerActionListener : TimerTask() {

        override fun run() {

            this@GamePanel.run()
        }
    }
}