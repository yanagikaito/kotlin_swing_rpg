import java.awt.BorderLayout
import javax.swing.JFrame

/**
 * ゲームフレーム
 */

class GameFrame : JFrame() {

    private var panel: GamePanel? = null

    /**
     * フレームの構築
     */

    init {

        // 親クラスのコンストラクタを呼び出す

        // フレームの閉じる操作を設定

        super.setDefaultCloseOperation(EXIT_ON_CLOSE)

        // レイアウトマネージャを設定

        super.setLayout(BorderLayout())

        // ゲームパネルを作成

        panel = GamePanel()

        // パネルをフレームのコンテンツペインに設定

        super.setContentPane(panel)

        // フレームを表示

        super.setVisible(true)

        // フレームのサイズを自動調整

        super.pack()

        super.setLocationRelativeTo(null)

        // フレームにフォーカスを設定

        super.requestFocus()

        panel!!.requestFocus()
    }
}