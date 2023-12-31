package main

import javax.swing.JFrame

object GameMain {
    @JvmStatic
    fun main(args: Array<String>) {

        val gamePanel = GamePanel()

        val window = JFrame("Game")

        window.add(gamePanel)

        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE)

        window.pack()

        window.isVisible = true

        window.setLocationRelativeTo(null)
    }
}